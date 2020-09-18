package com.refactoring.noteorganizerproject.entity.data_base.impl;



import com.refactoring.noteorganizerproject.BasePresenter;
import com.refactoring.noteorganizerproject.entity.AppConfig;
import com.refactoring.noteorganizerproject.entity.data_base.DataBase;
import com.refactoring.noteorganizerproject.entity.data_base.dao.TodoDAO;

import com.refactoring.noteorganizerproject.entity.shared_prefs.SharedPreferencesManager;
import com.refactoring.noteorganizerproject.todos.model.Todo;

import com.refactoring.noteorganizerproject.todos.notifications.Alarm;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class TodoDaoImpl {
    private final String CLASS_TAG = "TodoDaoImpl";
    private DataBase dataBase = AppConfig.getInstance().getDatabase();
    private TodoDAO todoDAO = dataBase.getTodoDao();
    private int NO_MESSAGE = 0;

    public List<Todo> todoList = new ArrayList<>();
    public Todo todo = new Todo();
    private Disposable disposable;

    public enum STATE {
        ALL, DONE, MISSED, CURRENT;
    }

    private STATE showState = STATE.ALL;
    private Alarm alarm = AppConfig.getInstance().getAlarm();

    public void getTodosByState(BasePresenter presenter) {
        switch (showState) {
            case ALL:
                getAll(presenter);
                break;
            case DONE:
                getDoneTodos(presenter);
                break;
            case MISSED:
                getMissedTodos(presenter);
                break;
            case CURRENT:
                getCurrentTodos(presenter);
                break;
        }
    }

    private void getAll(BasePresenter presenter) {
        disposable = todoDAO.getAll()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        listFromDB -> {
                            todoList.clear();
                            todoList.addAll(listFromDB);
                            presenter.notifyDatasetChanged(NO_MESSAGE);
                        },
                        Throwable::printStackTrace
                );
    }

    private void getDoneTodos(BasePresenter presenter) {
        disposable = todoDAO.getDoneTodos()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        doneTodos -> {
                            todoList.clear();
                            todoList.addAll(doneTodos);
                            System.out.println("GET");
                            presenter.notifyDatasetChanged(NO_MESSAGE);
                        },
                        Throwable::printStackTrace
                );
    }

    private void getMissedTodos(BasePresenter presenter) {
        long timeNow = System.currentTimeMillis();
        disposable = todoDAO.getMissedTodos(timeNow)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        missedTodoList -> {
                            todoList.clear();
                            todoList.addAll(missedTodoList);
                            presenter.notifyDatasetChanged(NO_MESSAGE);
                        },
                        Throwable::printStackTrace
                );
    }

    private void getCurrentTodos(BasePresenter presenter) {
        long timeNow = System.currentTimeMillis();
        System.out.println(timeNow);
        disposable = todoDAO.getCurrentTodos(timeNow)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        currentTodoList -> {
                            todoList.clear();
                            todoList.addAll(currentTodoList);
                            presenter.notifyDatasetChanged(NO_MESSAGE);
                        },
                        Throwable::printStackTrace
                );
    }

    public Integer size() {
        return todoList.size();
    }

    public void setTodo(int position) {
        todo = todoList.get(position);
    }
    public Todo getTodo() {
        return todo;
    }
    public void showAll(BasePresenter presenter) {
        showState = TodoDaoImpl.STATE.ALL;
        getTodosByState(presenter);
    }

    public void showDone(BasePresenter presenter) {
        showState = STATE.DONE;
        getTodosByState(presenter);
    }

    public void showCurrent(BasePresenter presenter) {
        showState = STATE.CURRENT;
        getTodosByState(presenter);
    }

    public void showMissed(BasePresenter presenter) {
        showState = STATE.MISSED;
        getTodosByState(presenter);
    }

    public SharedPreferencesManager getAppSettings() {
        return AppConfig.getInstance().getAppSettings();
    }

}
