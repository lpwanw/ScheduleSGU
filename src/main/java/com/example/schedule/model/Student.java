package com.example.schedule.model;

import java.util.List;

public class Student {
    private String mssv;
    private String name;
    private String dob;
    private List<Class> items;

    public Student(String mssv, String name, String dob, List<Class> items) {
        this.mssv = mssv;
        this.name = name;
        this.dob = dob;
        this.items = items;
    }

    public Student() {
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public List<Class> getItems() {
        return items;
    }

    public void setItems(List<Class> items) {
        this.items = items;
    }
}
