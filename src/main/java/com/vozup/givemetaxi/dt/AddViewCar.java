package com.vozup.givemetaxi.dt;

import com.vozup.givemetaxi.CarType;
import com.vozup.givemetaxi.entities.CarEntity;
import com.vozup.givemetaxi.entities.DriverEntity;
import com.vozup.givemetaxi.entities.OperatorEntity;
import com.vozup.givemetaxi.repository.CarRepository;
import com.vozup.givemetaxi.repository.DriverRepository;
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
    private Long driverId;
    private CarEntity selectedCar;

    @Inject
    CarRepository repository;
    @Inject
    DriverRepository driverRepository;

    @Transactional
    public void onRowEdit(RowEditEvent event){
        CarEntity updated = (CarEntity) event.getObject();



//        if (updated.getDriver() == null){
//            DriverEntity driver = driverRepository.findById(driverId).orElse(null);
//            if(driver == null){
//                showMessage("No available driver with " + driverId + " driverId");
//                return;
//            }
//            updated.setDriver(driver);
//            repository.save(updated);
//
//            driver.setCar(updated);
//            driverRepository.save(driver);
//
//            showMessage("Car Edited");
//        }else{
//            repository.save(updated);
//            showMessage("Car Edited");
//        }
    }

    public void onRowCancel(RowEditEvent event) {
        showMessage("Edit Cancelled");
    }

    public void onAddNew() {
        // Add one new car to the table:
        CarEntity operatorEntity = new CarEntity();

        operatorEntity.setCarType(CarType.STANDART);

        repository.save(operatorEntity);

        showMessage("New Car added");
    }

    private void showMessage(String str){
        FacesMessage msg = new FacesMessage(str);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public CarEntity getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(CarEntity selectedCar) {
        this.selectedCar = selectedCar;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public List<CarEntity> getCars() {
        cars = repository.findAll();
        return cars;
    }

    public void setCars(List<CarEntity> cars) {
        this.cars = cars;
    }
}
