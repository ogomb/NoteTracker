package com.classified.ogomb.notetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

public class NoteFragment  extends Fragment {
    private Note  mNote;
    private EditText mNoteText;
    private EditText mNoteTitle;
    private CheckBox mDoneCheckBox;
    private Button mReportButton;
    private static final String ARG_NOTE_ID = "note_id";

    public static NoteFragment newInstance(UUID noteId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_NOTE_ID, noteId);

        NoteFragment fragment = new NoteFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        UUID noteId = (UUID) getArguments().getSerializable(ARG_NOTE_ID);
        mNote = NoteLab.get(getActivity()).getNote(noteId);
    }
    @Override
    public void onPause(){
        super.onPause();
        NoteLab.get(getActivity()).updateNote(mNote);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_note,container,false);

        mNoteTitle = view.findViewById(R.id.note_title);
        mNoteTitle.setText(mNote.getTitle());
        mNoteTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mNote.setTitle(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mNoteText = view.findViewById(R.id.noteText);
        mNoteText.setText(mNote.getNote());
        mNoteText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mNote.setNote(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mDoneCheckBox = view.findViewById(R.id.note_done);
        mDoneCheckBox.setChecked(mNote.isDone());
        mDoneCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    mNote.setDone(isChecked);
            }
        });

        mReportButton = view.findViewById(R.id.send_report_button);
        mReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, getNoteReport());
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.note_report_subject));
                intent = Intent.createChooser(intent, getString(R.string.send_report));
                startActivity(intent);
            }
        });


        return view;
    }

    private String getNoteReport(){
        String doneString = null;
        if (mNote.isDone()){
            doneString = getString(R.string.note_report_done);
        }else {
            doneString = getString(R.string.note_report_not_done);
        }

        String dateFormat = "EEE, MMM dd";
        String dateString = DateFormat.format(dateFormat, mNote.getDate()).toString();

        String report = getString(R.string.note_report, mNote.getTitle(), dateString, doneString);

        return report;
    }

}
