package com.vozup.givemetaxi.entityes;

import javax.persistence.*;

@Entity
@Table(name = "driver")
public class DriverEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    @OneToOne
    private CarEntity car;
    private String phoneNumber;
    private boolean isSmoking;

    public DriverEntity(String firstName, String lastName, CarEntity car, String phoneNumber, boolean isSmoking) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.car = car;
        this.phoneNumber = phoneNumber;
        this.isSmoking = isSmoking;
    }

    public DriverEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
