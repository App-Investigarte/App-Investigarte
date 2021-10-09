package com.app_investigarte.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    //Cursor c = null;

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

}
