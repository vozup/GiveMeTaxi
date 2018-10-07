package com.vozup.givemetaxi.views;

import com.vozup.givemetaxi.entities.CarEntity;
import org.primefaces.event.DragDropEvent;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("dndCarsView")
@ViewScoped
public class DNDCarsView {
    private CarEntity dropedCar;

    public void onCarDrop(DragDropEvent ddEvent) {
        CarEntity car = ((CarEntity) ddEvent.getData());
        System.out.println("Droped Car ");
        dropedCar = car;
    }

}
