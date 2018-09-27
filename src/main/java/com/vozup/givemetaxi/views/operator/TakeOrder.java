package com.vozup.givemetaxi.views.operator;

import com.vozup.givemetaxi.CallList;
import com.vozup.givemetaxi.CarType;
import com.vozup.givemetaxi.OrderQuery;
import com.vozup.givemetaxi.entities.OrderEntity;
import com.vozup.givemetaxi.repository.OrderRepository;
import org.springframework.dao.DataIntegrityViolationException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private String clientPhoneNumber;
    private String distanceValue;
    private String distanceText;
    private Map<CarType, Integer> priceForKm;
    private Integer price;
    @Inject
    AdditionalService service;
    @Inject
    OrderRepository orderRepository;
    @Inject
    OrderQuery orderQuery;

    @PostConstruct
    private void init(){
        priceForKm = new HashMap<>();
        priceForKm.put(CarType.STANDART, 10);
        priceForKm.put(CarType.BUISNESS, 20);
        priceForKm.put(CarType.COMFORT, 25);
        priceForKm.put(CarType.MICROBUS, 25);

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
        orderEntity.setCarType(CarType.valueOf(carType));

        try {
            //orderRepository.save(orderEntity);
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
        Integer priceTemp = priceForKm.get(CarType.valueOf(carType));
        price = priceTemp * Integer.getInteger(distanceValue);
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

    public String getOtherInfoToDriver() {
        return otherInfoToDriver;
    }

    public void setOtherInfoToDriver(String otherInfoToDriver) {
        this.otherInfoToDriver = otherInfoToDriver;
    }
}
