package com.vozup.givemetaxi.entities;

import org.apache.commons.lang3.RandomUtils;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "driver")
public class DriverEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String carAddress;
    @OneToOne
    private CarEntity car;
    private String phoneNumber;
    private boolean isSmoking;
    private boolean isBusy;
    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
    private List<OrderEntity> orders;

    public DriverEntity(String firstName, String lastName, CarEntity car, String phoneNumber, boolean isSmoking) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.car = car;
        this.phoneNumber = phoneNumber;
        this.isSmoking = isSmoking;
    }

    public DriverEntity() {
    }

    public DriverEntity randomDriver() {
        DriverEntity driver = new DriverEntity();
        int a = RandomUtils.nextInt(10, 100);
        driver.setFirstName("NewDriver" + a);
        driver.setLastName("NewDriver" + a);
        driver.setPhoneNumber("+3809112322" + a);
        return driver;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSmoking() {
        return isSmoking;
    }

    public void setSmoking(boolean smoking) {
        isSmoking = smoking;
    }

    public String getCarAddress() {
        return carAddress;
    }

    public void setCarAddress(String carAddress) {
        this.carAddress = carAddress;
    }
}
