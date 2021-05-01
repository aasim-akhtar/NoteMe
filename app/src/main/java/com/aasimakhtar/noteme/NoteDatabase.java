package com.aasimakhtar.noteme;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NoteDatabase extends SQLiteOpenHelper {
//Required for constructor
    public static final int DATABSE_VERSION = 2;
    public static final String DATABASE_NAME = "notesdb";
    public static final String DATABASE_TABLE = "notestable";

    //columns name for database table
    public static final String KEY_ID = "id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_CONTEXT = "context";
    public static final String KEY_DATE = "date";
    public static final String KEY_TIME = "time";

    NoteDatabase(Context context){
        super(context,DATABASE_NAME,null,DATABSE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
//        create table table_name(id INT PRIMARY KEY, title TEXT,context  TEXT,date TEXT,time TEXT);

        String query = "CREATE TABLE"+ DATABASE_TABLE +"("+ KEY_ID +"INT PRIMARY KEY," +
                KEY_TITLE + "TEXT,"+
                KEY_CONTEXT + "TEXT,"+
                KEY_DATE + "TEXT,"+
                KEY_TIME + "TEXT" + ")";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion>=newVersion)
            return;
        db.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE);
        onCreate(db);

    }
}
