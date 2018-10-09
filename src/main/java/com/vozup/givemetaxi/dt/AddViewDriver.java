package com.vozup.givemetaxi.dt;

import com.vozup.givemetaxi.entities.CarEntity;
import com.vozup.givemetaxi.entities.DriverEntity;
import com.vozup.givemetaxi.repository.CarRepository;
import com.vozup.givemetaxi.repository.DriverRepository;
import org.apache.commons.lang3.RandomUtils;
import org.primefaces.event.RowEditEvent;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("dtDriver")
public class AddViewDriver {
    private List<DriverEntity> drivers;
    private DriverEntity selectedDriver;
    private Long carId;
    @Inject
    DriverRepository repository;
    @Inject
    CarRepository carRepository;

    public void onRowEdit(RowEditEvent event) {
        DriverEntity updated = (DriverEntity) event.getObject();
        //Before Car.id == null
        //After CarId == id
        if (updated.getCar() == null && carId != null){
            System.out.println("Driver class, car==null");
            System.out.println("CarId "+ carId);
        }
        //Before Car.id == id
        //After CarId == id
        else if(updated.getCar() != null && carId != null){
            System.out.println("Driver class, car!=null");
            System.out.println("CarId "+ carId);
        }else if(updated.getCar() == null && carId == null){

        }else if(updated.getCar() != null && carId == null){

        }







        //System.out.println(carId);
        //CarEntity car = carRepository.findById(carId).orElse(null);
//        if (car == null){
//            showMessage("No avaible car with " + carId + " carId");
//            return;
//        }
//        updated.setCar(car);
//        repository.save(updated);
//
//        car.setDriver(updated);
//        carRepository.save(car);
//
//        showMessage("Driver Edited");
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
