package com.classified.ogomb.notetracker.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.classified.ogomb.notetracker.database.NoteDbSchema.NoteTable;

/**
 * Created by lewismbogo on 12/04/2018.
 */

public class NoteBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME ="noteBase.db";

    public NoteBaseHelper(Context context){
        super(context, DATABASE_NAME,null,VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + NoteTable.NAME + "(" +
        " _id integer primary key autoincrement, " +
        NoteTable.Cols.UUID + ", "+
        NoteTable.Cols.TITLE + ", " +
        NoteTable.Cols.NOTE_BODY + ", "+
        NoteTable.Cols.DATE + ", " +
        NoteTable.Cols.DONE + ")" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int olderVersion, int newVersion) {

    }
}
