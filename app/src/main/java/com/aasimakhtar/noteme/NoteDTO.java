package com.aasimakhtar.noteme;

public class NoteDTO {
    private long ID;
    private String title,context,date,time;

    public NoteDTO() {}

    public NoteDTO(long ID, String title, String context, String date, String time) {
        this.ID = ID;
        this.title = title;
        this.context = context;
        this.date = date;
        this.time = time;
    }

    public NoteDTO(String title, String context, String date, String time) {
        this.title = title;
        this.context = context;
        this.date = date;
        this.time = time;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
