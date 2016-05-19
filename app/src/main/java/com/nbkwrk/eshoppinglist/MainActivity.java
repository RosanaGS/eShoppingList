package com.nbkwrk.eshoppinglist;


import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Abrimos la base de datos en modo escritura
		AndroidSQLiteHelper usdbh =
		new AndroidSQLiteHelper(this, "Productos", null, 9);
		SQLiteDatabase db = usdbh.getWritableDatabase();
		//Si hemos abierto correctamente la base de datos
		if(db != null)
		{
			String[] args = new String[] {"1"};
			//Cursor c = db.rawQuery(" SELECT Descripcion FROM Producto WHERE Estado=? ", args);
			Cursor c = db.query("Producto", new String[] {"Descripcion"}, "Estado=?", args,null,null,"Descripcion");
			if (c.moveToFirst()) 
			{
				final String[] datos = new String[c.getCount()];
				
				
				
				//Recorremos el cursor hasta que no haya m�s registros
				for(int i=0; i<c.getCount();i++)
				{
					datos[i] = c.getString(0);
					c.moveToNext();
				}
				
				ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datos);
				ListView lstCompra = (ListView)findViewById(R.id.LstCompra);
				lstCompra.setAdapter(adaptador);
			}
			
			
			db.close();
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
