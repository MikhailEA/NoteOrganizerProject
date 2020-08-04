package com.refactoring.noteorganizerproject.notes.notes_list_fragment.presenter;

import android.view.View;

import com.refactoring.noteorganizerproject.BasePresenter;

public interface INotesPresenter extends BasePresenter {
    void getNotes();
    void bindView (IViewHolder viewHolder);
    int getItemCount ();
    void clicked (int position);
    void longClicked (int position, View v);

}
