package com.vozup.givemetaxi;

import javax.inject.Named;
import java.util.Date;
import java.util.List;

@Named
public class TakeOrder {
    private String fromAddress;
    private String toAddress;
    private Date onDate;
    private String carService;
    private List<String> additionalService;
    private String otherInfoToDriver;


    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public Date getOnDate() {
        return onDate;
    }

    public void setOnDate(Date onDate) {
        this.onDate = onDate;
    }

    public String getCarService() {
        return carService;
    }

    public void setCarService(String carService) {
        this.carService = carService;
    }

    public List<String> getAdditionalService() {
        return additionalService;
    }

    public void setAdditionalService(List<String> additionalService) {
        this.additionalService = additionalService;
    }

    public String getOtherInfoToDriver() {
        return otherInfoToDriver;
    }

    public void setOtherInfoToDriver(String otherInfoToDriver) {
        this.otherInfoToDriver = otherInfoToDriver;
    }
}
