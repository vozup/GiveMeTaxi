package com.vozup.givemetaxi.entities;

import com.vozup.givemetaxi.enums.CarType;

import javax.persistence.*;

@Entity
@Table(name = "cars", schema = "schema")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Типа сервис(Стандарт, Комфорт, Бизнес, Универсал, Микроавтобус)
    @Enumerated(EnumType.STRING)
    private CarType carType;
    //Модель машины
    private String carModel;
    //Марка машины
    private String carBrand;
    //Номер машины
    @Column(unique = true)
    private String carNumber;
    //Техпаспорт
    @Column(unique = true)
    private String technicalCoupon;
    //Номер страховки
    @Column(unique = true)
    private String numberOfCoverage;
    @OneToOne
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

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
