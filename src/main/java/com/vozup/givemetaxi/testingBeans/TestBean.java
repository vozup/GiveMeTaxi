package com.vozup.givemetaxi.testingBeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
public class TestBean {
    private String addressFrom;
    private String addressTo;
    private String distanceText;
    private String distanceValue;
    private String price;
    private String name5;

    public void showDistanceAndCalculatePrice() {
        //calculatePrice();
        sendMessage("Дистанция: " + distanceText);
    }

    private void sendMessage(String text) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, text, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    private void calculatePrice(){
        System.out.println(Integer.getInteger(distanceValue));
        int pr = Integer.getInteger(distanceValue)/1000 * 11;
        price = Integer.toString(pr);
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public String getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(String addressFrom) {
        this.addressFrom = addressFrom;
    }

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
    }

    public String getName5() {
        return name5;
    }

    public void setName5(String name5) {
        this.name5 = name5;
    }
}
