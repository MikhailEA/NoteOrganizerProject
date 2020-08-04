package com.refactoring.noteorganizerproject.notes.notes_list_fragment.view;

import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class NotesFragmentInitialize extends Fragment {
    View root;
    RecyclerView recyclerView;
    private FloatingActionButton writeNewNote;
    MaterialButton sortNotes;
    TextInputEditText searchNoteTv;

    INotesPresenter presenter;

    LinearLayoutCompat sortLayout;
    ConstraintLayout extraOptionsLayout;
}
