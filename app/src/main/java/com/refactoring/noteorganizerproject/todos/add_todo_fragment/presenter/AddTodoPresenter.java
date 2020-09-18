package com.refactoring.noteorganizerproject.todos.add_todo_fragment.presenter;

import com.refactoring.noteorganizerproject.BasePresenter;
import com.refactoring.noteorganizerproject.entity.data_base.impl.TodoDaoImpl;
import com.refactoring.noteorganizerproject.entity.shared_prefs.SharedPreferencesManager;
import com.refactoring.noteorganizerproject.todos.add_todo_fragment.view.IAddTodoFragment;
import com.refactoring.noteorganizerproject.todos.model.Todo;
import com.refactoring.noteorganizerproject.utils.DateUtils;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class AddTodoPresenter extends MvpPresenter<IAddTodoFragment> implements BasePresenter {

    private SharedPreferencesManager appSettings;
    private TodoDaoImpl todoDao;

    public AddTodoPresenter() {
        todoDao = new TodoDaoImpl();
        appSettings = todoDao.getAppSettings();
    }

    public boolean isNewTodo() {
        return appSettings.getClickedTodoId() == -1;
    }

    private void setUIData() {
        Todo todo = todoDao.todo;
        String[] dateTime = DateUtils.dateToString(todo.endDate).split(" ");
        String date = dateTime[0];
        String time = dateTime[1];
        if (DateUtils.isDateConfigured(date)) {
            getViewState().setDate(date);
            getViewState().setTime(time);
        }
        getViewState().setTitle(todo.title);
        getViewState().setDescription(todo.description);
    }

    public void getUIData() {
        long id = appSettings.getClickedTodoId();
        todoDao.getTodo(id, this);
    }

    @Override
    public void notifyDatasetChanged(int messageId) {
        setUIData();
    }
}
