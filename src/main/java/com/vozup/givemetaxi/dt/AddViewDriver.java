package com.vozup.givemetaxi.dt;

import com.vozup.givemetaxi.entities.CarEntity;
import com.vozup.givemetaxi.entities.DriverEntity;
import com.vozup.givemetaxi.repository.CarRepository;
import com.vozup.givemetaxi.repository.DriverRepository;
import org.apache.commons.lang3.RandomUtils;
import org.apache.log4j.Logger;
import org.primefaces.event.RowEditEvent;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("dtDriver")
public class AddViewDriver {
    private static final Logger LOGGER = Logger.getLogger(AddViewDriver.class);
    private List<DriverEntity> drivers;
    private DriverEntity selectedDriver;
    private Long carId;
    @Inject
    DriverRepository repository;
    @Inject
    CarRepository carRepository;

    public void onRowEdit(RowEditEvent event) {
        DriverEntity updated = (DriverEntity) event.getObject();
        //System.out.println(carId + " " + updated.getCar().getId());
        if (updated.getCar() == null && carId == null) {
            repository.save(updated);
            return;
        }
        ///
        if (repository.findFirstByCarId(carId) != null && carId == updated.getCar().getId()) {
            repository.save(updated);
            return;
        }

        if (updated.getCar() == null || carId != null) {
            System.out.println(carId);
            CarEntity car = carRepository.findById(carId).orElse(null);
            if (car.getDriver() != null) {
                showMessage("Driver with car already exist");
                LOGGER.error("Driver with car already exist");
                return;
            }
            if (car == null) {
                showMessage("No avaible car with " + carId + " carId");
                LOGGER.error("No avaible car with " + carId + " carId");
                return;
            }
            updated.setCar(car);
            repository.save(updated);

            car.setDriver(updated);
            carRepository.save(car);

            showMessage("Driver Edited");
            LOGGER.info("Edit Row with driver ID: " + updated.getId());
        } else if (carId == null) {
            CarEntity car = updated.getCar();

            updated.setCar(null);
            repository.save(updated);

            car.setDriver(null);
            carRepository.save(car);

            showMessage("Driver Edited");
            LOGGER.info("Edit Row with driver ID: " + updated.getId());
        }
    }

    public void deleteRow() {
        if (selectedDriver.getCar() != null) {
            showMessage("Can't delete, always set link to Car");
            LOGGER.error("Can't delete, always set link to Car");
            return;
        } else {
            LOGGER.info("Delete Row with driver ID: " + selectedDriver.getId());
            repository.delete(selectedDriver);
        }
    }

    public void onRowCancel(RowEditEvent event) {
        showMessage("Edit Cancelled");
    }

    //Добавляет только одного
    public void onAddNew() {
        // Add one new car to the table:
        DriverEntity driverEntity = new DriverEntity();
        int a = RandomUtils.nextInt(0, 100);
        driverEntity.setFirstName("NewDriver" + a);
        driverEntity.setLastName("NewDriver" + a);
        System.out.println(driverEntity.getFirstName());
        repository.save(driverEntity);
        showMessage("New Driver added");
        LOGGER.info("Add Row with driver ID: ");
    }

    private void showMessage(String str){
        FacesMessage msg = new FacesMessage(str);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * Доработать
     *
     * @return
     */
    public List<DriverEntity> getDrivers() {
        drivers = repository.findAll();
        return drivers;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public void setDrivers(List<DriverEntity> drivers) {
        this.drivers = drivers;
    }

    public DriverEntity getSelectedDriver() {
        return selectedDriver;
    }

    public void setSelectedDriver(DriverEntity selectedDriver) {
        this.selectedDriver = selectedDriver;
    }
}
