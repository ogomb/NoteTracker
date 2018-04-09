package com.classified.ogomb.notetracker;

import java.util.Date;
import java.util.UUID;

/**
 * Created by lewismbogo on 09/04/2018.
 */

public class Note {
    private UUID mId;
    private Date mDate;
    private String mNote;

    public Note(){
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getNote() {
        return mNote;
    }

    public void setNote(String note) {
        mNote = note;
    }
}
