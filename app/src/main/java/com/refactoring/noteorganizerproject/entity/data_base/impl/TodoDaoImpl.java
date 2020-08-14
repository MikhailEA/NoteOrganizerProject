package com.refactoring.noteorganizerproject.entity.data_base.impl;



import com.refactoring.noteorganizerproject.entity.AppConfig;
import com.refactoring.noteorganizerproject.entity.data_base.DataBase;
import com.refactoring.noteorganizerproject.entity.data_base.dao.TodoDAO;
import com.refactoring.noteorganizerproject.entity.shared_prefs.SharedPreferencesManager;
import com.refactoring.noteorganizerproject.todos.model.Todo;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

public class TodoDaoImpl {
    private final String CLASS_TAG = "TodoDaoImpl";
    private DataBase dataBase = AppConfig.getInstance().getDatabase();
    private TodoDAO todoDAO = dataBase.getTodoDao();
    private int NO_MESSAGE = 0;

    public List<Todo> todoList = new ArrayList<>();
    public Todo todo = new Todo();
    private Disposable disposable;


    public SharedPreferencesManager getAppSettings() {
        return AppConfig.getInstance().getAppSettings();
    }
}
