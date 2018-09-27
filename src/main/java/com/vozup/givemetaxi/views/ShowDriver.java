package com.vozup.givemetaxi.views;

import com.vozup.givemetaxi.CarType;
import com.vozup.givemetaxi.entities.DriverEntity;
import com.vozup.givemetaxi.repository.DriverRepository;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ShowDriver {
    private List<DriverEntity> drivers;
    @Inject
    DriverRepository driverRepository;

    @PostConstruct
    void init(){
        drivers = driverRepository.findAll();
    }

    public List<DriverEntity> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<DriverEntity> drivers) {
        this.drivers = drivers;
    }
}
