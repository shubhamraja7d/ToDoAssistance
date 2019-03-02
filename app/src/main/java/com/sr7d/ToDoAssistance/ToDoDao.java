package com.sr7d.ToDoAssistance;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ToDoDao {

    @Query("SELECT * FROM ToDo")
    List<ToDo> getAll();

    @Insert
    void insert(ToDo todo);

    @Delete
    void delete(ToDo todo);



}
