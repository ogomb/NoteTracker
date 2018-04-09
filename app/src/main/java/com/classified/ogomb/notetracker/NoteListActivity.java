package com.classified.ogomb.notetracker;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NoteListActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new NoteListFragment();
    }

}
