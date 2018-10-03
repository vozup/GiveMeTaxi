package com.vozup.givemetaxi.views.operator;

import com.vozup.givemetaxi.CarType;
import com.vozup.givemetaxi.MapTest;
import com.vozup.givemetaxi.OrderQuery;
import com.vozup.givemetaxi.entities.OrderEntity;
import com.vozup.givemetaxi.repository.OrderRepository;
import org.springframework.dao.DataIntegrityViolationException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Time;
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
    private CarType carType = CarType.STANDART;
    private List<String> additionalService;
    private String otherInfoToDriver;
    private String clientPhoneNumber;
    private String distanceValue;
    private String distanceText;
    private Integer price;
    @Inject
    AdditionalService service;
    @Inject
    OrderRepository orderRepository;
    @Inject
    OrderQuery orderQuery;
    @Inject
    MapTest mapTest;

    @PostConstruct
    private void init(){
        price = 0;
    }

    public void actionTakeOrder(){
        additionalService = service.getSelectedAdditionalService();

        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setReceived(false);
        orderEntity.setFromAddress(fromAddress);
        orderEntity.setToAddress(toAddress);
        //-----
        orderEntity.setDate(onDate);
        orderEntity.setTime(Time.valueOf(timeFormat.format(onDate)));
        orderEntity.setClientPhoneNumber(clientPhoneNumber);

        orderEntity.setAdditionalService(additionalService.toString());
        orderEntity.setMessageForDriver(otherInfoToDriver);
        orderEntity.setCarType(carType);

        try {
            orderRepository.save(orderEntity);
        }catch (DataIntegrityViolationException e){
                e.printStackTrace();
                LOGGER.info(fromAddress + " " +
                        toAddress + " " +
                        onDate + " " +
                        timeFormat.format(onDate) + " " +
                        carType + " " +
                        additionalService.toString() + " " +
                        otherInfoToDriver);
        }

        orderQuery.addOrder(orderEntity);

    }

    public void calculatePrice(){
        LOGGER.info("distanceValue " + distanceValue + " " + "Car type " + carType);
        price = Integer.parseInt(distanceValue.trim()) / 1000 * mapTest.priceForKm(carType);
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDistanceValue() {
        return distanceValue;
    }

    public void setDistanceValue(String distanceValue) {
        this.distanceValue = distanceValue;
    }

    public String getDistanceText() {
        return distanceText;
    }

    public void setDistanceText(String distanceText) {
        this.distanceText = distanceText;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
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

    public String getOtherInfoToDriver() {
        return otherInfoToDriver;
    }

    public void setOtherInfoToDriver(String otherInfoToDriver) {
        this.otherInfoToDriver = otherInfoToDriver;
    }
}
