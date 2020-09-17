package com.refactoring.noteorganizerproject.notes.notes_list_fragment.presenter;

import android.text.TextWatcher;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NotesListenersProvider {
    private INotesSortingPresenter presenter;

    public NotesListenersProvider(INotesSortingPresenter iNotesPresenter) {
        this.presenter = iNotesPresenter;
    }


    public TextWatcher getTextChangeListener(View buttonClear) {
    }

    public ChipGroup.OnCheckedChangeListener getOnCheckedChangeListener() {
    }


    public RecyclerView.OnScrollListener getRecyclerScrollListener(FloatingActionButton fab) {
    }
}
