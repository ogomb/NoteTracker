package com.classified.ogomb.notetracker;

import java.util.Date;
import java.util.UUID;

public class Note {
    private UUID mId;
    private Date mDate;
    private String mTitle;
    private String mNote;
    private Boolean mDone;

    public Note(){
        this(UUID.randomUUID());
    }

    public Note(UUID id){
        mId = id;
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

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setDone(Boolean done) {
        mDone = done;
    }
}
