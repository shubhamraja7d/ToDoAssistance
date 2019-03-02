package com.sr7d.ToDoAssistance;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {ToDo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ToDoDao toDoDao();
}
