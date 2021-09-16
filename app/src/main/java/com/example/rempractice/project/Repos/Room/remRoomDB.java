package com.example.rempractice.project.Repos.Room;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.rempractice.project.Repos.Model.remDTO;
import com.example.rempractice.project.Repos.Room.DAO.DAO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {remDTO.class}, version = 1, exportSchema = false)
public abstract class remRoomDB extends RoomDatabase {
    public abstract DAO dao();

    private static volatile remRoomDB INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static remRoomDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (remRoomDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), remRoomDB.class, "reminders_database")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
