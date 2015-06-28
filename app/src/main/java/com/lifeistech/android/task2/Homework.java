package com.lifeistech.android.task2;

import java.util.*;

public class Homework {
    private String title;
    private String page;
    //private int page;
    private Date date;

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

    /*public int getPage(){
        return page;
    }
    public void SetPage(int page1){
        this.page=page1;
    }*/



    public Date getDate(){
        return date;
    }

    public void setDate(Date date1){
        this.date=date1;
    }
}
