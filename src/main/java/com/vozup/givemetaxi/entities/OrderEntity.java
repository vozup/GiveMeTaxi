package com.vozup.givemetaxi.entities;

import com.vozup.givemetaxi.enums.CarType;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


@Entity
@Table(name = "orders", schema = "schema")
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
    private String clientPhoneNumber;
    @Column(nullable = false)
    private String price;
    private boolean received;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id", nullable = true)
    private DriverEntity driver;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operator_id", nullable = true)
    private OperatorEntity operator;

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", fromAddress='" + fromAddress + '\'' +
                ", toAddress='" + toAddress + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", carType=" + carType +
                ", additionalService='" + additionalService + '\'' +
                ", messageForDriver='" + messageForDriver + '\'' +
                ", clientPhoneNumber='" + clientPhoneNumber + '\'' +
                ", price='" + price + '\'' +
                ", received=" + received +
                '}';
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public OperatorEntity getOperator() {
        return operator;
    }

    public void setOperator(OperatorEntity operator) {
        this.operator = operator;
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
        return received;
    }

    public void setReceived(boolean received) {
        this.received = received;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public DriverEntity getDriver() {
        return driver;
    }

    public void setDriver(DriverEntity driver) {
        this.driver = driver;
    }
}
