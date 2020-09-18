package com.refactoring.noteorganizerproject.todos.todos_faragment.presenter;

import com.refactoring.noteorganizerproject.BasePresenter;
import com.refactoring.noteorganizerproject.notes.notes_list_fragment.view.recycler.IViewHolder;

public interface ITodoPresenter extends BasePresenter {
    void getTodos();
    void bindView(IViewHolder viewHolder);
    int getItemCount();

    void deleteTodo();
    void saveTodo(String title, String description, Long dateTime, boolean timeChosen);
    void editTodo(String title, String description, Long dateTime, boolean timeChosen, int action);
    void makeTodoDone(int position, boolean isDone);
    default void notifyItemChanged(int position) { }

    void longClicked(int position);
    void clicked(int position);

}
