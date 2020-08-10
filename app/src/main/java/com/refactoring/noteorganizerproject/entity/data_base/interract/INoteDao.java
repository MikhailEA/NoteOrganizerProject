package com.refactoring.noteorganizerproject.entity.data_base.interract;

import com.refactoring.noteorganizerproject.notes.model.Note;

public interface INoteDao {
    void saveNote(Note note);
    void updateNote(Note note);
    void deleteNote(Note note);

    

}
