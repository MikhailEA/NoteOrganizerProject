package com.refactoring.noteorganizerproject.notes.notes_list_fragment.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.refactoring.noteorganizerproject.R;
import com.refactoring.noteorganizerproject.notes.notes_list_fragment.presenter.INotesPresenter;
import com.refactoring.noteorganizerproject.notes.notes_list_fragment.presenter.NotesPresenter;


public class NotesFragmentInitialize extends Fragment {
    View root;
    RecyclerView recyclerView;
    private FloatingActionButton writeNewNote;
    MaterialButton sortNotes;
    TextInputEditText searchNoteTv;

    INotesPresenter presenter;

    LinearLayoutCompat sortLayout;
    ConstraintLayout extraOptionsLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_notes, container, false);

        initUI();
        initRecyclerView();

        return root;
    }

    private void initRecyclerView() {
    }

    private void initUI() {

    }

    private void initPresenter(NotesFragment notesFragment) {
        presenter = new NotesPresenter(fragment);
    }
}
