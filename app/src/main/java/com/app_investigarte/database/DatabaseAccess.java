package com.app_investigarte.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    //private constructor so that  object creation from outside the class is avoided
    //constructor
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    //to return the single instance of detabase
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    //to open the database
    public void open() {
        this.db = openHelper.getWritableDatabase();
    }

    //closing the database connection
    public void close() {
        if (db != null) {
            this.db.close();
        }
    }


    public int CantidadArtefactosSubR(int subregion) {
        c = db.rawQuery("select COUNT(*) FROM Artifact a inner join Municipality m on a.id_municipality = m.id WHERE m.id_subregions = "+subregion +";", null);

        int cantidad = 0;
        while (c.moveToNext()) {
            cantidad = c.getInt(0);
        }
        return cantidad;
    }



    //Consulta Listado de artefactos

    public String[][] getArtifactSubregion(int subregion, int cantidaRegistros) {
        c = db.rawQuery("select a.id, a.name, a.image, a.id_municipality, m.name, m.id_subregions FROM Artifact a inner join Municipality m on a.id_municipality = m.id WHERE m.id_subregions = "+subregion +";",null);
        int columnas=6;
        String arr[][] = new String[cantidaRegistros][columnas];

        for (int i = 0; i < columnas; i++) {
            c.moveToFirst();
            for (int j = 0; j < cantidaRegistros; j++) {
                arr[j][i] = c.getString(i);
                c.moveToNext();
            }
        }
        return arr;
    }

}
