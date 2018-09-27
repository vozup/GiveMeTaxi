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
    private Integer priceForOrder;

    private Map<CarType, Integer> priceForKm;

    private String from;
    private String to;

//    @PostConstruct
//    private void init(){
//        priceForKm = new HashMap<>();
//        priceForKm.put(CarType.STANDART, 10);
//        priceForKm.put(CarType.BUISNESS, 20);
//        priceForKm.put(CarType.COMFORT, 25);
//        priceForKm.put(CarType.MICROBUS, 25);
//    }

    public Integer calculatePrice(String carType){
        Integer price = priceForKm.get(CarType.valueOf(carType));
        return Integer.getInteger(distanceValue) * price;
    }

    public Integer getPriceForOrder() {
        return priceForOrder;
    }

    public void setPriceForOrder(Integer priceForOrder) {
        this.priceForOrder = priceForOrder;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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
