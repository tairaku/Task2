package com.lifeistech.android.task2;

import java.util.*;
import java.io.Serializable;

public class Homework implements Serializable {

    private String title;
    private String page;
    //private int page;
    //private Date date;
    private int month;
    private int day;

    public String getTitle(){
        return title;
    }

    public void setTitle(String title1){
        this.title=title1;
    }

    public String getPage(){
        return page;
    }

    public void setPage(String page1){
        this.page=page1;
    }

    public int getMonth(){
        return month;
    }

    public void setMonth(int month1){
        this.month=month1;
    }

    public int getDay(){
        return day;
    }

    public void setDay(int day1){
        this.day=day1;
    }

}
