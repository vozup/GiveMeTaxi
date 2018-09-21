package com.vozup.givemetaxi.entities;

import com.vozup.givemetaxi.CarType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orderTable")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fromAddress;
    private String toAddress;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Enumerated(EnumType.STRING)
    private CarType carType;
    private String additionalService;
    private String messageForDriver;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getAdditionalService() {
        return additionalService;
    }

    public void setAdditionalService(String additionalService) {
        this.additionalService = additionalService;
    }

    public String getMessageForDriver() {
        return messageForDriver;
    }

    public void setMessageForDriver(String messageForDriver) {
        this.messageForDriver = messageForDriver;
    }
}
