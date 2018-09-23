package com.vozup.givemetaxi.views;

import javax.inject.Named;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Named
public class OrderDate {
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");

    private Date date;
    private Date currentDate;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCurrentDate() {
        currentDate = new Date();
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
}
