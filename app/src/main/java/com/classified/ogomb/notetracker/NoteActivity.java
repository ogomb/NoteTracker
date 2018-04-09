package com.classified.ogomb.notetracker;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;


public class NoteActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new NoteFragment();
    }
}
