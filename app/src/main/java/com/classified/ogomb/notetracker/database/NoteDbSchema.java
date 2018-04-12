package com.classified.ogomb.notetracker.database;

/**
 * Created by lewismbogo on 12/04/2018.
 */

public class NoteDbSchema {
    public static final class NoteTable {
        public static final String NAME = "notes";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String NOTE_BODY = "note_body";
            public static final String DATE = "date";
            public static final String DONE = "done";
        }
    }

}
