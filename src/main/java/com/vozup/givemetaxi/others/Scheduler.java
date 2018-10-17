package com.vozup.givemetaxi.others;

import com.vozup.givemetaxi.entities.DriverEntity;
import com.vozup.givemetaxi.entities.OrderEntity;
import com.vozup.givemetaxi.repository.DriverRepository;
import com.vozup.givemetaxi.repository.OrderRepository;
import com.vozup.givemetaxi.twilio.TwilioInit;
import org.springframework.scheduling.annotation.Scheduled;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Scheduler {
    @Inject
    TwilioInit twilio;
    @Inject
    DriverRepository driverRepository;
    @Inject
    OrderRepository orderRepository;
    private Integer period = 0;

    @Scheduled(initialDelay = 10000, fixedDelay = 10000)
    public void findFreeCar() {
        if (period == 5) {
            period = 0;
            DriverEntity dr = driverRepository.findFirstByBusyIs(true);
            if (dr != null) {
                dr.setBusy(false);
                driverRepository.save(dr);
            }
        }
        period++;
        //System.out.println("scheldure is started");
        DriverEntity driver = null;
        OrderEntity order = orderRepository.findFirstByReceivedIsFalse();
        if(order != null){
            driver = driverRepository.findFirstByBusyIsFalseAndCarCarTypeIs(order.getCarType());
        }else{
            //System.out.println("No avaible order");
            return;
        }
        if (driver == null){
            //System.out.println("No avaible cartype for order");
            return;
        }
        else {
            driver.addOrder(order);
            driver.setBusy(true);
            driverRepository.save(driver);
            //Send SMS
//            String message = driver.getCar().getCarModel() + " "
//                    + driver.getCar().getCarBrand() + " "
//                    + driver.getCar().getCarNumber() + " "
//                    + driver.getPhoneNumber();
//            twilio.sendSms("+380972763063", message);

            order.setDriver(driver);
            order.setReceived(true);
            orderRepository.save(order);
        }
        //System.out.println("scheldure is finished");
    }
}
