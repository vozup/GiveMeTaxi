package com.vozup.givemetaxi.testingBeans;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class CarList {
    List<Car> cars;
    Car selectedCar;

    @PostConstruct
    private void init(){
        cars = new ArrayList<>();

        cars.add(new Car("Киев, Оболонь"));
        cars.add(new Car("Киев, Дарница"));
        cars.add(new Car("Киев, улица Харьковское шоссе, 152"));
        cars.add(new Car("Киев, жд Вокзал"));
        cars.add(new Car("Киев, вулиця Пушкінська, 13"));

        selectedCar = cars.get(0);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
}
