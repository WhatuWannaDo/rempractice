package com.example.rempractice.project.Repos.Room;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.rempractice.Domain.reminders;
import com.example.rempractice.project.Repos.Model.remDTO;
import com.example.rempractice.project.Repos.RepTasks;
import com.example.rempractice.project.Repos.Room.DAO.DAO;

import java.util.List;

public class remRepos implements RepTasks {
    private DAO dao;
    private LiveData<List<remDTO>> allReminders = new MutableLiveData<>();

    public remRepos(Application app){
        remRoomDB db = remRoomDB.getDatabase(app);
        dao = db.dao();
        allReminders = dao.getAllReminders();
    }
    public LiveData<List<remDTO>> getAllReminders() {
        return allReminders;
    }

    @Override
    public <T extends reminders> void addReminder(T rems) {
        remRoomDB.databaseWriteExecutor.execute(() -> {
            dao.addReminder(((remDTO) rems));
        });
    }

    @Override
    public <T extends reminders> void deleteReminder(T rems) {
        remRoomDB.databaseWriteExecutor.execute(() -> {
            dao.deleteReminder(((remDTO) rems));
        });
    }
/*
    @Override
    public < extends reminders> void updateReminder(boolean rems) {
        remRoomDB.databaseWriteExecutor.execute(() -> {
            dao.updateRem(((remDTO) rems));
        });
    }

 */
}
