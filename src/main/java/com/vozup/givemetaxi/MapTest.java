package com.vozup.givemetaxi;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
public class MapTest {
    private String distanceText;
    private String distanceValue;

    private Map<CarType, Integer> priceForKm;

    @PostConstruct
    private void init(){
        priceForKm = new HashMap<>();
        priceForKm.put(CarType.STANDART, 10);
        priceForKm.put(CarType.BUISNESS, 20);
        priceForKm.put(CarType.UNIVERSAL, 20);
        priceForKm.put(CarType.COMFORT, 25);
        priceForKm.put(CarType.MICROBUS, 25);
    }

    public Integer priceForKm(String carType){
        if (carType != null){
            return priceForKm.get(CarType.valueOf(carType));
        }
        else return 0;
    }

    public Integer priceForKm(CarType carType){
        if (carType != null){
            return priceForKm.get(carType);
        }
        else return 0;
    }

    public void showDistance() {
        sendMessage("Дистанция: " + distanceText);
    }

    private void sendMessage(String text) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, text, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getDistanceText() {
        return distanceText;
    }

    public void setDistanceText(String distanceText) {
        this.distanceText = distanceText;
    }

    public String getDistanceValue() {
        return distanceValue;
    }

    public void setDistanceValue(String distanceValue) {
        this.distanceValue = distanceValue;
    }
}
