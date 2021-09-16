package com.example.rempractice.project.Repos;

import androidx.lifecycle.LiveData;

import com.example.rempractice.Domain.reminders;

import java.util.List;

public interface RepTasks {
    <T extends reminders> LiveData<List<T>> getAllReminders();
    <T extends reminders> void addReminder(T rem);
    <T extends reminders> void deleteReminder(T rem);
}
