package com.example.rempractice.project.Repos.Room.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.rempractice.project.Repos.Model.remDTO;

import java.util.List;

@Dao
public interface DAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addReminder(remDTO rem);

    @Delete
    void deleteReminder(remDTO rem);

    @Query("SELECT * FROM reminders")
    LiveData<List<remDTO>> getAllReminders();
}
