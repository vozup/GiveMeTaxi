package com.vozup.givemetaxi.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "driver")
public class DriverEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FIRSTNAME")
    private String firstName;
    private String lastName;
    private String carAddress;
    @OneToOne
    private CarEntity car;
    private String phoneNumber;
    private boolean smoking;
    private boolean busy;
    @OneToMany(mappedBy = "driver", fetch = FetchType.EAGER)
    private List<OrderEntity> orders;

    public DriverEntity(String firstName, String lastName, CarEntity car, String phoneNumber, boolean smoking) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.car = car;
        this.phoneNumber = phoneNumber;
        this.smoking = smoking;
    }

    public DriverEntity() {
    }

    public void addOrder(OrderEntity order){
        if (orders.isEmpty()) orders = new ArrayList<>();
        else orders.add(order);
    }

    @Override
    public String toString() {
        return "DriverEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", carAddress='" + carAddress + '\'' +
                ", car=" + car +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", smoking=" + smoking +
                ", busy=" + busy +
                '}';
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

    public void setId(String id) {
        this.id = Long.valueOf(id);
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
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
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public String getCarAddress() {
        return carAddress;
    }

    public void setCarAddress(String carAddress) {
        this.carAddress = carAddress;
    }
}
