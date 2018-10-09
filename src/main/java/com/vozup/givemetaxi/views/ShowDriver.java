package com.vozup.givemetaxi.views;

import com.vozup.givemetaxi.entities.DriverEntity;
import com.vozup.givemetaxi.repository.DriverRepository;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ShowDriver {
    private List<DriverEntity> drivers;
    private DriverEntity selectedDriver;
    @Inject
    DriverRepository driverRepository;

    @PostConstruct
    void init(){
        //drivers = driverRepository.findAllByBusyIsFalse();
    }

    public List<DriverEntity> getDrivers() {
        drivers = driverRepository.findAllByBusyIsFalseAndCarIsNotNull();
        return drivers;
    }

    public void setDrivers(List<DriverEntity> drivers) {
        this.drivers = drivers;
    }

    public DriverEntity getSelectedDriver() {
        return selectedDriver;
    }

    public void setSelectedDriver(DriverEntity selectedDriver) {
        this.selectedDriver = selectedDriver;
    }
}
