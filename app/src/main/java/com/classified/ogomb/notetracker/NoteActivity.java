package com.classified.ogomb.notetracker;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class NoteActivity extends SingleFragmentActivity {
    private static final String EXTRA_NOTE_ID = "com.labs.classified.notetracker.note_id";

    @Override
    public Fragment createFragment() {
        UUID noteId = (UUID)getIntent()
                .getSerializableExtra(EXTRA_NOTE_ID);
        return NoteFragment.newInstance(noteId);
    }

    public static Intent newIntent(Context packageContext, UUID noteId){
        Intent intent = new Intent(packageContext, NoteActivity.class);
        intent.putExtra(EXTRA_NOTE_ID, noteId);
        return intent;
    }
}
