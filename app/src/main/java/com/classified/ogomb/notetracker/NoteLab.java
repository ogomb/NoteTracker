package com.classified.ogomb.notetracker;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by lewismbogo on 09/04/2018.
 */

public class NoteLab {
    private static NoteLab sNoteLab;
    private List<Note> mNotes;

    private NoteLab(Context context){
        mNotes = new ArrayList<>();
        for (int i= 0; i< 50; i++){
            Note  note = new Note();
            note.setNote("Note # " + i);
            note.setDone(i % 2 == 0);

            mNotes.add(note);
        }
    }
    public static NoteLab get(Context context){
        if (sNoteLab == null){
            return new NoteLab(context);
        }
        return sNoteLab;
    }

    public List<Note> getNotes(){
        return mNotes;
    }

    public Note getNote(UUID id){
        for (Note note: mNotes){
            if (note.getId().equals(id)){
                return note;
            }
        }
        return null;
    }

}
