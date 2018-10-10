package com.vozup.givemetaxi.enums;


public enum CarType {
    STANDART("STANDART"),
    COMFORT("COMFORT"),
    BUISNESS("BUISNESS"),
    UNIVERSAL("UNIVERSAL"),
    MICROBUS("MICROBUS");

    String carType;

    CarType(String carType) {
        this.carType = carType;
    }
}
