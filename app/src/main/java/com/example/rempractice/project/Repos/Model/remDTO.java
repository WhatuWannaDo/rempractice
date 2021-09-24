package com.example.rempractice.project.Repos.Model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.Gson;

import com.example.rempractice.Domain.reminders;

import java.util.Collections;
import java.util.List;


@Entity(tableName = "reminders")
public class remDTO extends reminders {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo
    public int id;
    @ColumnInfo
    public String text;
    @ColumnInfo
    public String date;
    @ColumnInfo
    public boolean isDone;
    @ColumnInfo
    public String images;



    @Override
    public String getTextRem() {
        return super.getTextRem().toString();
    }

    @Override
    public void setTextRem(String textRem) {
        super.setTextRem(textRem);
    }

    @Override
    public String getDateRem() {
        return super.getDateRem();
    }

    @Override
    public void setDateRem(String dateRem) {
        super.setDateRem(dateRem);
    }

    @Override
    public boolean isDone() {
        return super.isDone();
    }

    @Override
    public void setDone(boolean done) {
        super.setDone(done);
    }

    @Override
    public List<String> getImages() {
        if (super.getImages() == null || super.getImages().isEmpty()) {
            super.setImages(new Gson().fromJson(this.images, List.class));
        }
        return super.getImages();
    }
    @Override
    public void setImages(List<String> images) {
        super.setImages(images);
        this.images = new Gson().toJson(images);
    }
}
