package com.refactoring.noteorganizerproject.notes.notes_list_fragment.view.recycler;

import com.refactoring.noteorganizerproject.notes.model.Note;

public interface IViewHolder {
    void setNote(Note note);
    int getPos();
}
