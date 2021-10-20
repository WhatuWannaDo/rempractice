package com.example.rempractice.project.Repos.Mock;

import androidx.lifecycle.MutableLiveData;

import com.example.rempractice.Domain.reminders;
import com.example.rempractice.project.Repos.RepTasks;

import java.util.ArrayList;
import java.util.List;

public class MDB implements RepTasks {
    MutableLiveData<List<reminders>> data = new MutableLiveData<>();
    List<reminders> list;

    public MutableLiveData<List<reminders>> getAllReminders(){
        return data;
    }


    public MDB(){
        list = new ArrayList<>();

        reminders rem1 = new reminders();
        rem1.setTextRem("Пожрать");
        rem1.setDateRem("16.09.2021");
        rem1.setDone(false);
        list.add(rem1);

        reminders rem2 = new reminders();
        rem2.setTextRem("Поспать");
        rem2.setDateRem("15.09.2021");
        rem2.setDone(true);
        list.add(rem2);

        data.setValue(list);
    }

    public <T extends reminders> void addReminder(T rem){
        list.add(rem);
        data.setValue(list);
    }

    @Override
    public <T extends reminders> void deleteReminder(T rem) {
        list.remove(rem);
        data.setValue(list);
    }
/*
    @Override
    public <T extends reminders> void updateReminder(boolean rem) {
        data.setValue(list);
    }

 */
}
