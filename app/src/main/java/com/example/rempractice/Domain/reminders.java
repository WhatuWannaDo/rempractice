package com.example.rempractice.Domain;

import java.util.List;

public class reminders {
    private String textRem, dateRem;
    private boolean isDone;
    private List<String> images;

    public reminders(){}

    public reminders(String textRem, String dateRem, boolean isDone, List<String> img) {
        this.textRem = textRem;
        this.dateRem = dateRem;
        this.isDone = isDone;
        this.images = img;
    }

    public String getTextRem() {
        return textRem;
    }

    public void setTextRem(String textRem) {
        this.textRem = textRem;
    }

    public String getDateRem() {
        return dateRem;
    }

    public void setDateRem(String dateRem) {
        this.dateRem = dateRem;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
