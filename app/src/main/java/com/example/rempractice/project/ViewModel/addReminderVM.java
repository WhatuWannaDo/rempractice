package com.example.rempractice.project.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.rempractice.project.Repos.Model.remDTO;
import com.example.rempractice.project.Repos.Repos;

import java.util.List;

public class addReminderVM extends ViewModel {
    public void addReminder(String textRem, String date, boolean isDone, List<String> images){
        remDTO dto = new remDTO();
        dto.setTextRem(textRem);
        dto.setDateRem(date);
        dto.setDone(isDone);
        dto.setImages(images);

        Repos.getRepos().addReminder(dto);
    }
}
