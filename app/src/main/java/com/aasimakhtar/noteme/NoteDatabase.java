package com.aasimakhtar.noteme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class NoteDatabase extends SQLiteOpenHelper {
//Required for constructor
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "notesdb";
    public static final String DATABASE_TABLE = "notestable";

    //columns name for database table
    public static final String KEY_ID = "id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_CONTEXT = "context";
    public static final String KEY_DATE = "date";
    public static final String KEY_TIME = "time";

    NoteDatabase(Context context){
//        super() constructor used to create database
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
//        create table table_name(id INT PRIMARY KEY, title TEXT,context  TEXT,date TEXT,time TEXT);

        String query = "CREATE TABLE "+ DATABASE_TABLE +"("+ KEY_ID +" INT PRIMARY KEY," +
                KEY_TITLE + " TEXT,"+
                KEY_CONTEXT + " TEXT,"+
                KEY_DATE + " TEXT,"+
                KEY_TIME + " TEXT" + ")";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        changes to new sql version
        if (oldVersion>=newVersion)
            return;
        db.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE);
        onCreate(db);

    }

//    storing data into db
    public long AddNote(NoteDTO note){
        SQLiteDatabase db = this.getWritableDatabase(); //writable
        ContentValues c = new ContentValues(); //creates dictionary like structure for accessing data

        c.put(KEY_TITLE,note.getTitle());
        c.put(KEY_CONTEXT,note.getContext());
        c.put(KEY_DATE,note.getDate());
        c.put(KEY_TIME,note.getTime());

        long ID = db.insert(DATABASE_TABLE,null,c);
        Log.d("INSERTED", "ID -->"+ ID);
        return ID;
    }

//    fetch one single note from database using note ID
    public NoteDTO getNote(long id){
//        select * from databaseTable where id=?
        SQLiteDatabase db = this.getReadableDatabase();
//        query returns position which is stored in cursor
        Cursor cursor = db.query(DATABASE_TABLE,new String[]{KEY_ID,KEY_TITLE,KEY_CONTEXT,KEY_DATE,KEY_TIME},KEY_ID+"=?",
                new String[]{String.valueOf(id)},null,null,null);
//        =? used to prevent sqli
        if (cursor != null){
//            cursor starts from -1
            cursor.moveToFirst();
        }
//        object used to store note properties, getLong is for id, get string is for name and all others
        NoteDTO note = new NoteDTO(cursor.getLong(0),cursor.getString(1),cursor.getString(2),
                cursor.getString(3),cursor.getString(4));
        return note;
    }

//    fetch all notes from db
    public List<NoteDTO> getNotes(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<NoteDTO> allNotes = new ArrayList<>();
//        select * from databasename;
        String query = "SELECT * FROM "+ DATABASE_TABLE;

        Cursor cursor = db.rawQuery(query,null);
        if (cursor != null){
            do {
                NoteDTO note = new NoteDTO();
                note.setID(cursor.getLong(0));
                note.setTitle(cursor.getString(1));
                note.setContext(cursor.getString(2));
                note.setDate(cursor.getString(3));
                note.setTime(cursor.getString(4));

                allNotes.add(note);
            }while (cursor.moveToNext());
        }
        return allNotes;
    }

}
