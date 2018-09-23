package com.vozup.givemetaxi;

import com.vozup.givemetaxi.entities.OrderEntity;
import com.vozup.givemetaxi.repository.OrderRepository;
import com.vozup.givemetaxi.views.AdditionalService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Logger;

@Named
public class TakeOrder {
    private static final Logger LOGGER = Logger.getLogger(TakeOrder.class.getName());

    private String fromAddress;
    private String toAddress;
    private Date onDate;
    private String carType;
    private List<String> additionalService;
    private String otherInfoToDriver;
    @Inject
    AdditionalService service;
    @Inject
    OrderRepository orderRepository;

    public void actionTakeOrder(){
        additionalService = service.getSelectedAdditionalService();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");

        LOGGER.info(fromAddress + " " +
        toAddress + " " +
        //dateFormat.format(onDate) + " " +
                onDate + " " +
                carType + " " +
                additionalService.toString() + " " +
                otherInfoToDriver);

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setReceived(false);
        orderEntity.setFromAddress(fromAddress);
        orderEntity.setToAddress(toAddress);
        //-----
        orderEntity.setDate(onDate);
        //orderEntity.setTime(onDate);

        orderEntity.setAdditionalService(additionalService.toString());
        orderEntity.setMessageForDriver(otherInfoToDriver);
        orderEntity.setCarType(CarType.valueOf(carType));

        //orderRepository.save(orderEntity);
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public Date getOnDate() {
        return onDate;
    }

    public void setOnDate(Date onDate) {
        this.onDate = onDate;
    }



    public List<String> getAdditionalService() {
        return additionalService;
    }

    public void setAdditionalService(List<String> additionalService) {
        this.additionalService = additionalService;
    }

    public String getOtherInfoToDriver() {
        return otherInfoToDriver;
    }

    public void setOtherInfoToDriver(String otherInfoToDriver) {
        this.otherInfoToDriver = otherInfoToDriver;
    }
}
