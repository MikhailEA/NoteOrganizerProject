package com.refactoring.noteorganizerproject.todos.todos_faragment.presenter;

import com.refactoring.noteorganizerproject.entity.data_base.impl.TodoDaoImpl;
import com.refactoring.noteorganizerproject.entity.shared_prefs.SharedPreferencesManager;
import com.refactoring.noteorganizerproject.todos.todos_faragment.TodoRequestCodes;
import com.refactoring.noteorganizerproject.todos.todos_faragment.view.recycler.ITodosFragment;

import moxy.MvpPresenter;

public class TodosPresenter extends MvpPresenter<ITodosFragment> implements ITodoPresenter, TodoRequestCodes {
    private static final int NEW_TODO = -1;
    private SharedPreferencesManager appSettings;
    private TodoDaoImpl todoDao;

    public TodosPresenter() {
        todoDao = new TodoDaoImpl();
        appSettings = todoDao.getAppSettings();
    }


    @Override
    public void getTodos() {
        todoDao.getTodosByState(this);
    }
}
