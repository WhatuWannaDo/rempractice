package com.example.rempractice.project.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.rempractice.Domain.reminders;
import com.example.rempractice.project.Repos.Repos;

import java.util.List;

public class reminderVM extends ViewModel {

    public LiveData<List<reminders>> getRems(){
        return Repos.getRepos().getAllReminders();
    }

    public void deleteReminder(reminders rem){
        Repos.getRepos().deleteReminder(rem);
    }
}
