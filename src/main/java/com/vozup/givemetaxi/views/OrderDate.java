package com.vozup.givemetaxi.views;

import javax.inject.Named;

@Named
public class OrderDate {
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
