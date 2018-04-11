package com.classified.ogomb.notetracker.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.classified.ogomb.notetracker.Note;
import com.classified.ogomb.notetracker.database.NoteDbSchema.NoteTable;

import java.util.Date;
import java.util.UUID;

/**
 * Created by lewismbogo on 12/04/2018.
 */

public class NoteCursorWrapper extends CursorWrapper {
    public NoteCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Note getNote(){
        String uuidString = getString(getColumnIndex(NoteTable.Cols.UUID));
        String title = getString(getColumnIndex(NoteTable.Cols.TITLE));
        String note_body = getString(getColumnIndex(NoteTable.Cols.NOTE_BODY));
        long date = getLong(getColumnIndex(NoteTable.Cols.DATE));
        int done = getInt(getColumnIndex(NoteTable.Cols.DONE));


        Note note = new Note(UUID.fromString(uuidString));
        note.setTitle(title);
        note.setNote(note_body);
        note.setDate(new Date(date));
        note.setDone(done != 0);

        return note;
    }
}
