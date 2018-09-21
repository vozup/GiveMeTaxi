package com.vozup.givemetaxi.entityes;

import com.vozup.givemetaxi.CarType;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //Типа сервис(Стандарт, Комфорт, Бизнес, Универсал, Микроавтобус)
    @Enumerated(EnumType.STRING)
    private CarType carType;
    //Марка машины
    private String carModel;
    //Номер машины
    private String carNumber;
    //Техпаспорт
    private String technicalCoupon;
    //Номер страховки
    private String numberOfCoverage;
    @OneToOne()
    private DriverEntity driver;

    public CarEntity() {
    }

    public CarEntity(CarType carType, String carModel, String carNumber, String technicalCoupon, String numberOfCoverage) {
        this.carType = carType;
        this.carModel = carModel;
        this.carNumber = carNumber;
        this.technicalCoupon = technicalCoupon;
        this.numberOfCoverage = numberOfCoverage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getTechnicalCoupon() {
        return technicalCoupon;
    }

    public void setTechnicalCoupon(String technicalCoupon) {
        this.technicalCoupon = technicalCoupon;
    }

    public String getNumberOfCoverage() {
        return numberOfCoverage;
    }

    public void setNumberOfCoverage(String numberOfCoverage) {
        this.numberOfCoverage = numberOfCoverage;
    }

    public DriverEntity getDriver() {
        return driver;
    }

    public void setDriver(DriverEntity driver) {
        this.driver = driver;
    }
}
