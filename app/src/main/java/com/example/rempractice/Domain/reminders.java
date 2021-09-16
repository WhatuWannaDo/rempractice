package com.example.rempractice.Domain;

public class reminders {
    private String textRem, dateRem;
    private boolean isDone;

    public reminders(){}

    public reminders(String textRem, String dateRem, boolean isDone) {
        this.textRem = textRem;
        this.dateRem = dateRem;
        this.isDone = isDone;
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
}
