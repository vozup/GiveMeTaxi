package com.vozup.givemetaxi.views;

import com.vozup.givemetaxi.CarType;
import com.vozup.givemetaxi.entities.CarEntity;
import com.vozup.givemetaxi.entities.OperatorEntity;
import com.vozup.givemetaxi.repository.CarRepository;
import org.apache.commons.lang3.RandomUtils;
import org.primefaces.event.RowEditEvent;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@Named("dtCar")
public class AddViewCar {
    private List<CarEntity> cars;

    @Inject
    CarRepository repository;

    @Transactional
    public void onRowEdit(RowEditEvent event){
        CarEntity updated = (CarEntity) event.getObject();

        FacesMessage msg = new FacesMessage("Car Edited", ((CarEntity) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((CarEntity) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onAddNew() {
        // Add one new car to the table:
        CarEntity operatorEntity = new CarEntity();

        operatorEntity.setCarType(CarType.STANDART);

        repository.save(operatorEntity);

        FacesMessage msg = new FacesMessage("New Car added", operatorEntity.getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<CarEntity> getCars() {
        cars = repository.findAll();
        return cars;
    }

    public void setCars(List<CarEntity> cars) {
        this.cars = cars;
    }
}
