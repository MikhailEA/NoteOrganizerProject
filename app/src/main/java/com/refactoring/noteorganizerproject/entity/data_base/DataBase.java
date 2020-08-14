package com.refactoring.noteorganizerproject.entity.data_base;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.refactoring.noteorganizerproject.entity.data_base.dao.NoteDAO;
import com.refactoring.noteorganizerproject.entity.data_base.dao.TodoDAO;
import com.refactoring.noteorganizerproject.notes.model.Note;
import com.refactoring.noteorganizerproject.todos.model.Todo;

@Database(entities = {Note.class, Todo.class}, version = 1)
public abstract class DataBase extends RoomDatabase {
    public abstract NoteDAO getNoteDao();
    public abstract TodoDAO getTodoDao();
}
