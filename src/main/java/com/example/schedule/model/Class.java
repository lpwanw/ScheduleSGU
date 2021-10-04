package com.example.schedule.model;

import java.util.ArrayList;

public class Class {
    private String Name;
    private String Room;
    private int tietBatDau;
    private int soTiet;
    private int date;
    private boolean isFast;
    public Class() {
    }

    public Class(String name, String room, int tietBatDau, int soTiet, int date) {
        Name = name;
        Room = room;
        this.tietBatDau = tietBatDau;
        this.soTiet = soTiet;
        this.date = date;
        this.isFast = false;
    }
    public Class(String name, String room, int tietBatDau, int soTiet, int date,boolean isFast) {
        Name = name;
        Room = room;
        this.tietBatDau = tietBatDau;
        this.soTiet = soTiet;
        this.date = date;
        this.isFast = isFast;
    }

    public boolean isFast() {
        return isFast;
    }

    public void setFast(boolean fast) {
        isFast = fast;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRoom() {
        return Room;
    }

    public void setRoom(String room) {
        Room = room;
    }

    public int getTietBatDau() {
        return tietBatDau;
    }

    public void setTietBatDau(int tietBatDau) {
        this.tietBatDau = tietBatDau;
    }

    public int getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(int soTiet) {
        this.soTiet = soTiet;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Class{" +
                "Môn học='" + Name + '\'' +
                ", Phòng='" + Room + '\'' +
                ", Tiết bắt đầu=" + tietBatDau +
                ", Số tiết=" + soTiet +
                ", Thứ=" + date +
                '}';
    }
}
