package com.example.rempractice.project.Repos.Model;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.rempractice.Domain.reminders;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
}
