package com.refactoring.noteorganizerproject.entity.data_base;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.refactoring.noteorganizerproject.entity.data_base.dao.NoteDao;
import com.refactoring.noteorganizerproject.entity.data_base.dao.TodoDao;
import com.refactoring.noteorganizerproject.notes.model.Note;
import com.refactoring.noteorganizerproject.todos.model.Todo;

@Database(entities = {Note.class, Todo.class}, version = 1)
public abstract class DataBase extends RoomDatabase {
    public abstract NoteDao getNoteDao();
    public abstract TodoDao getTodoDao();
}
