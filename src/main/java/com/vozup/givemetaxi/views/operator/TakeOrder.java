package com.vozup.givemetaxi.views.operator;

import com.vozup.givemetaxi.CarType;
import com.vozup.givemetaxi.PriceForKm;
import com.vozup.givemetaxi.entities.DriverEntity;
import com.vozup.givemetaxi.entities.OrderEntity;
import com.vozup.givemetaxi.repository.DriverRepository;
import com.vozup.givemetaxi.repository.OperatorRepository;
import com.vozup.givemetaxi.repository.OrderRepository;
import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Named
public class TakeOrder {
    private static final Logger log = Logger.getLogger(TakeOrder.class);

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
    PriceForKm priceForKm;
    @Inject
    CheckOperator operator;
    /////////
    @Inject
    OperatorRepository repository;
    @Inject
    DriverRepository driver;

    @PostConstruct
    private void init(){
        price = 0;
    }

    public void actionTakeOrder(){
        log.info("In actionTakeOrder()");
        additionalService = service.getSelectedAdditionalService();

        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setReceived(false);
        orderEntity.setFromAddress(fromAddress);
        orderEntity.setToAddress(toAddress);
        //-----
        orderEntity.setDate(onDate);
        /**
         *  @inspect Сохраняет не 07 а 7 минут
         *  Log4j dont work
         */
        orderEntity.setTime(Time.valueOf(timeFormat.format(onDate)));
        orderEntity.setClientPhoneNumber(clientPhoneNumber);

        orderEntity.setAdditionalService(additionalService.toString());
        orderEntity.setMessageForDriver(otherInfoToDriver);
        orderEntity.setCarType(carType);
        //Hardcore
        orderEntity.setOperator(repository.findById(1L).get());
        //////////////////////
//        if (operator.getLogin() != null) {
//            orderEntity.setOperator(repository.findByLogin(operator.getLogin()));
//            orderEntity.setDriver(driver.findById(1L).get());
//        } else{
//            showMessage("Нет водителя или не выполнен вход");
//            log.error("Нет водителя или не выполнен вход");
//            return;
//        }
        /////////////////////
        try {
            orderRepository.save(orderEntity);
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            log.error(fromAddress + " " +
                    toAddress + " " +
                    onDate + " " +
                    timeFormat.format(onDate) + " " +
                    carType + " " +
                    additionalService.toString() + " " +
                    otherInfoToDriver);
        }
        showMessage("Заказ отправлен в обработку");
        log.info(fromAddress + " " +
                toAddress + " " +
                onDate + " " +
                timeFormat.format(onDate) + " " +
                carType + " " +
                additionalService.toString() + " " +
                otherInfoToDriver);
    }

    //Доработать
    public void calculatePrice(){
        log.info("distanceValue " + distanceValue + " " + "Car type " + carType);
        Integer distanceInKm = Integer.parseInt(distanceValue.trim()) / 1000;
        if (distanceInKm < 5) price = 50;
        else price = distanceInKm * priceForKm.priceForKm(carType);
    }

    private void showMessage(String str) {
        FacesMessage message = new FacesMessage(str);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, message);
    }

    public CarType[] getCarTypes() {
        return CarType.values();
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
