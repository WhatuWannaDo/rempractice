package com.example.rempractice.project.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rempractice.DI.adressChoose;
import com.example.rempractice.project.Repos.Model.remDTO;
import com.example.rempractice.project.Repos.Repos;

import java.util.List;

public class addReminderVM extends ViewModel {
    public void addReminder(String textRem, String date, boolean isDone, List<String> images, String adress){
        remDTO dto = new remDTO();
        dto.setTextRem(textRem);
        dto.setDateRem(date);
        dto.setDone(isDone);
        dto.setImages(images);
        dto.setAdress(adress);

        Repos.getRepos().addReminder(dto);
    }
    public LiveData<List<String>> getAddressList(String address_prototype) {
        return adressChoose.getInstance().getAnalysis().getAddressesFromPattern(address_prototype);
    }
/*
    public void updateReminder(boolean isDone){
        remDTO dto = new remDTO();
        dto.setDone(isDone);
    }

 */
}
