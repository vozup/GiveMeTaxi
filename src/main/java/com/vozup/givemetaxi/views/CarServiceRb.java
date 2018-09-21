package com.vozup.givemetaxi.views;

import javax.inject.Named;

@Named
public class CarServiceRb {
    private String carService;

    public String getCarService() {
        return carService;
    }

    public void setCarService(String carService) {
        this.carService = carService;
    }
}
