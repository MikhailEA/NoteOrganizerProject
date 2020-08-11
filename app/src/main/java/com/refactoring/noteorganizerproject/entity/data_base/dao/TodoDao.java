package com.refactoring.noteorganizerproject.entity.data_base.dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface TodoDao {
    @Query("SELECT * FROM Todo WHERE parentId IS NULL")
    Single<List<Todo>> getAll();
}
