package com.refactoring.noteorganizerproject.notes.notes_list_fragment.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NotesFragment extends NotesFragmentInitialize {
    private final String CLASS_TAG = "NotesFragment";


    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        initPresenter(this);
        super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initPresenter(NotesFragment notesFragment) {
        presenter = new NotesPresenter(fragment);
    }
}