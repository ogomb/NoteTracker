package com.classified.ogomb.notetracker;

import java.util.Date;
import java.util.UUID;

public class Note {
    private UUID mId;
    private Date mDate;
    private String mNote;
    private Boolean mDone;

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

    public Boolean getDone() {
        return mDone;
    }

    public void setDone(Boolean done) {
        mDone = done;
    }
}
