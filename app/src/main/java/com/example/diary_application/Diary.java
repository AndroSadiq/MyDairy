package com.example.diary_application;

class Diary {
    String date,subject,matter;

    public Diary(String date, String subject, String matter) {
        this.date = date;
        this.subject = subject;
        this.matter = matter;
    }

    public String getDate() { return date; }

    public String getSubject() {
        return subject;
    }

    public String getMatter() {
        return matter;
    }
}