package com.refactoring.noteorganizerproject.notes.notes_list_fragment.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class NotesFragment extends NotesFragmentInitialize {
    private final String CLASS_TAG = "NotesFragment";


    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        initPresenter(this);
        super.onCreateView(inflater, container, savedInstanceState);
    }

    public void notifyDataChaged() {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null)
            adapter.notifyDataSetChanged();
    }

    public void setSortLayoutVisibility(boolean isVisible) {
        sortNotes.setChecked(isVisible);
        sortLayout.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    public void setExtraOptionsLayoutVisibility(boolean isVisible) {
        extraOptionsLayout.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }


    public String getSeachText() {
        if (searchNoteTv == null)
            return "";
        return searchNoteTv.getText().toString();
    }
}