package com.vozup.givemetaxi.entities;

import com.vozup.givemetaxi.CarType;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String fromAddress;
    @Column(nullable = false)
    private String toAddress;
    @Temporal(TemporalType.DATE)
    private Date date;
    private Time time;
    @Enumerated(EnumType.STRING)
    private CarType carType;
    private String additionalService;
    private String messageForDriver;
    private boolean isReceived;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
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

    public boolean isReceived() {
        return isReceived;
    }

    public void setReceived(boolean received) {
        isReceived = received;
    }
}
