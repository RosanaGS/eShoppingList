package com.nbkwrk.eshoppinglist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/*
 * Autor: RosanaGS
 */
public class AndroidSQLiteHelper extends SQLiteOpenHelper {
	 
    String sqlCreate1 = "CREATE TABLE Producto (Descripcion TEXT, Estado INTEGER)";
    public AndroidSQLiteHelper(Context contexto, String nombre,
                               CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate1);
                
        db.execSQL("Insert into Producto (Descripcion, Estado) values ('Macarrones','1')");
        db.execSQL("Insert into Producto (Descripcion, Estado) values ('Manzana','0')");
        db.execSQL("Insert into Producto (Descripcion, Estado) values ('Pollo','1')");
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, 
                          int versionNueva) {
       
    	db.execSQL("DROP TABLE IF EXISTS Producto");
    	db.execSQL(sqlCreate1);        
        db.execSQL("Insert into Producto (Descripcion, Estado) values ('Macarrones','1')");
        db.execSQL("Insert into Producto (Descripcion, Estado) values ('Manzana','0')");
        db.execSQL("Insert into Producto (Descripcion, Estado) values ('Pollo','1')");
    }
}
