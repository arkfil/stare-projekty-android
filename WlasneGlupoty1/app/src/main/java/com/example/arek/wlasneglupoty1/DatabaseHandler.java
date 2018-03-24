package com.example.arek.wlasneglupoty1;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arek on 19.04.2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "bazaNotatek";
    private static final String TABLE_NOTES = "notatki";
    private static final String KEY_ID = "_id";
    private static final String KEY_TITLE = "tytul";
    private static final String KEY_BODY = "tresc";

    private SQLiteDatabase db;

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_NOTES_TABLE = "CREATE TABLE " + TABLE_NOTES + "("+ KEY_ID + " INTEGER PRIMARY KEY,"+KEY_TITLE+
                " TEXT,"+KEY_BODY + " TEXT"+")";
        db.execSQL(CREATE_NOTES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_NOTES);
    }

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db=getWritableDatabase();
    }

    public void addNote(Notatka notatka){
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, notatka.getTytul());
        values.put(KEY_BODY, notatka.getTresc());
        db.insert(TABLE_NOTES, null, values);
    }

    public Notatka getNote(int id){
        Cursor cursor = db.query(TABLE_NOTES, new String[]{KEY_ID,KEY_TITLE,KEY_TITLE,KEY_BODY}, KEY_ID+
        "=?", new String[] { String.valueOf(id)},null, null, null, null);

        if(cursor!=null)
            cursor.moveToFirst();

        Notatka notatka = new Notatka(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));

        return notatka;

    }

    public List<Notatka> getAllNotes(){
        List<Notatka> noteList = new ArrayList<Notatka>();

        String selectQuery = "SELECT * FROM "+ TABLE_NOTES;

        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){
            do{
                Notatka notatka = new Notatka();
                notatka.setId(cursor.getInt(0));
                notatka.setTytul(cursor.getString(1));
                notatka.setTresc(cursor.getString(2));

                noteList.add(notatka);
            } while (cursor.moveToNext());


        }


        return noteList;
    }


    public int getNotesCount(){

        String countQuery = "SELECT * FROM " + TABLE_NOTES;
        Cursor cursor = db.rawQuery(countQuery, null);
        return cursor.getCount();

    }


    public int updateNote(Notatka notatka){
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, notatka.getTytul());
        values.put(KEY_BODY, notatka.getTresc());

        return db.update(TABLE_NOTES,values,KEY_ID + "=?",
                new String[] {String.valueOf(notatka.getId())});
    }

}
