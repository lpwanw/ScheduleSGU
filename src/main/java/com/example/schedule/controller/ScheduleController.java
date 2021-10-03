package com.example.schedule.controller;

import com.example.schedule.model.Class;
import com.example.schedule.model.Student;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ScheduleController {
    public static int getDate(String s){
        switch(s){
            case "Hai":{
                return 0;
            }
            case "Ba":{
                return 1;
            }
            case "Tư":{
                return 2;
            }
            case "Năm":{
                return 3;
            }
            case "Sáu":{
                return 4;
            }
            case "Bảy":{
                return 5;
            }
            default: {
                return -1;
            }
        }
    }
    @GetMapping("/schedule/{id}")
    public Student getSchedule(@PathVariable String id){
        Document doc = null;
        try {
            doc = Jsoup.connect("http://thongtindaotao.sgu.edu.vn/Default.aspx?page=thoikhoabieu&sta=1&id="+id).get();
        } catch (IOException e) {
            return null;
        }
        Student student = new Student();
        List<Class> items = new ArrayList<>();
        Element name = doc.getElementById("ctl00_ContentPlaceHolder1_ctl00_lblContentTenSV");
        String nameString = name.text();
        String nameSv = nameString.substring(0,nameString.indexOf(" - "));
        String dob = nameString.substring(nameString.indexOf(":")+1);
        Elements newsHeadlines = doc.select(".grid-roll2  .body-table tr");
        ArrayList<String> list = new ArrayList<>();
        newsHeadlines.forEach(a->{
            String s= a.text();
            if(s.contains("DSSV")){
                list.add(s);
            }
        });
        list.forEach(s-> {
            String maMon = s.substring(0, s.indexOf(" "));
            s = s.substring(maMon.length()+1);
            String tenMon = s.substring(0,s.indexOf(" 0"));
            s = s.substring(tenMon.length()+4);
            char tinChi = s.charAt(0);
            s = s.substring(1);
            s = s.substring(s.indexOf(" "+tinChi+" ")+3);
            if(s.charAt(0)=='0' && s.charAt(3)=='0'){
                String[] temp = s.split(" ");
                int thu1  = getDate(temp[2]);
                int thu3= getDate(temp[3]);
                int thu2  = getDate(temp[4]);
                int thu4= getDate(temp[5]);
                int tietBatDau1 = Integer.parseInt(temp[6]);
                int tietBatDau3 = Integer.parseInt(temp[7]);
                int tietBatDau2 = Integer.parseInt(temp[8]);
                int tietBatDau4 = Integer.parseInt(temp[9]);
                int soTiet1 = Integer.parseInt(temp[10]);
                int soTiet3 = Integer.parseInt(temp[11]);
                int soTiet2 = Integer.parseInt(temp[12]);
                int soTiet4 = Integer.parseInt(temp[13]);
                String room1 = temp[14];
                String room3 = temp[15];
                String room2 = temp[16];
                String room4 = temp[17];
                Class tiet1 = new Class(tenMon,room1,tietBatDau1,soTiet1,thu1,true);
                Class tiet2 = new Class(tenMon,room2,tietBatDau2,soTiet2,thu2,true);
                Class tiet3 = new Class(tenMon,room3,tietBatDau3,soTiet3,thu3,true);
                Class tiet4 = new Class(tenMon,room4,tietBatDau4,soTiet4,thu4,true);
                items.add(tiet1);
                items.add(tiet2);
                items.add(tiet3);
                items.add(tiet4);
            }else
            if(s.charAt(0)=='0'){
                String[] temp = s.split(" ");
                int thu1  = getDate(temp[1]);
                int thu2= getDate(temp[2]);
                int tietBatDau1 = Integer.parseInt(temp[3]);
                int tietBatDau2 = Integer.parseInt(temp[4]);
                int soTiet1 = Integer.parseInt(temp[5]);
                int soTiet2 = Integer.parseInt(temp[6]);
                String room1 = temp[7];
                String room2 = temp[8];
                Class tiet1 = new Class(tenMon,room1,tietBatDau1,soTiet1,thu1);
                Class tiet2 = new Class(tenMon,room2,tietBatDau2,soTiet2,thu2);
                items.add(tiet1);
                items.add(tiet2);
            }else{
                String[] temp = s.split(" ");
                int thu  = getDate(temp[0]);
                int tietBatDau = Integer.parseInt(temp[1]);
                int soTiet = Integer.parseInt(temp[2]);
                String room = temp[3];
                Class tiet1 = new Class(tenMon,room,tietBatDau,soTiet,thu);
                items.add(tiet1);
            }
        });
        student.setName(nameSv);
        student.setDob(dob);
        student.setMssv(id);
        student.setItems(items);
        return student;
    }

}
