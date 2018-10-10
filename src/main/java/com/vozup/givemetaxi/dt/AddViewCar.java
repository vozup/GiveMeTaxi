package com.vozup.givemetaxi.dt;

import com.vozup.givemetaxi.entities.CarEntity;
import com.vozup.givemetaxi.enums.CarType;
import com.vozup.givemetaxi.repository.CarRepository;
import org.apache.log4j.Logger;
import org.primefaces.event.RowEditEvent;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@Named("dtCar")
public class AddViewCar {
    private static final Logger LOGGER = Logger.getLogger(AddViewCar.class);
    private List<CarEntity> cars;
    private Long driverId;
    private CarEntity selectedCar;

    @Inject
    CarRepository repository;

    @Transactional
    public void onRowEdit(RowEditEvent event){
        CarEntity updated = (CarEntity) event.getObject();

        repository.save(updated);
        showMessage("Car Edited");
        LOGGER.info("Edited Row with car ID: " + updated.getId());
    }

    public void onRowCancel(RowEditEvent event) {
        showMessage("Edit Cancelled");
    }

    public void onAddNew() {
        // Add one new car to the table:
        CarEntity carEntity = new CarEntity();

        carEntity.setCarType(CarType.STANDART);

        repository.save(carEntity);

        showMessage("New Car added");
        LOGGER.info("Add Row with car ID: ");
    }

    private void showMessage(String str){
        FacesMessage msg = new FacesMessage(str);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteRow() {
        if (selectedCar.getDriver() != null) {
            showMessage("Can't delete, always set link to Driver");
            LOGGER.error("Can't delete, always set link to Driver");
        } else {
            repository.delete(selectedCar);
            LOGGER.info("Deleted Row with car ID: " + selectedCar.getId());
        }
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
