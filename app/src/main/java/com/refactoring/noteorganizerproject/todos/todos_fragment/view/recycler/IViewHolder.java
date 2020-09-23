package com.refactoring.noteorganizerproject.todos.todos_fragment.view.recycler;

import com.refactoring.noteorganizerproject.todos.model.Todo;

public interface IViewHolder {
    void setTodo(Todo todo);
    int getPos();
}
