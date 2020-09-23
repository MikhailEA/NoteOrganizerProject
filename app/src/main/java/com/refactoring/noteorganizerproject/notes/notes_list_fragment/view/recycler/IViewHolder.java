package com.refactoring.noteorganizerproject.notes.notes_list_fragment.view.recycler;

import com.refactoring.noteorganizerproject.notes.model.*;
import com.refactoring.noteorganizerproject.todos.model.Todo;

public interface IViewHolder {
    void setNote(Note note);
    int getPos();

    void setTodo(Todo todo);
}
