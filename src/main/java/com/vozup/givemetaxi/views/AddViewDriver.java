package com.vozup.givemetaxi.views;

import com.vozup.givemetaxi.entities.DriverEntity;
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
    @Inject
    DriverRepository repository;

    public void onRowEdit(RowEditEvent event) {
        DriverEntity temp = (DriverEntity) event.getObject();


        FacesMessage msg = new FacesMessage("Driver Edited", ((DriverEntity) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((DriverEntity) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onAddNew() {
        // Add one new car to the table:
        DriverEntity driverEntity = new DriverEntity();
        int a = RandomUtils.nextInt(0, 100);
        driverEntity.setFirstName("NewDriver" + a);
        driverEntity.setLastName("NewDriver" + a);

        repository.save(driverEntity);

        FacesMessage msg = new FacesMessage("New Driver added", driverEntity.getId().toString());
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
