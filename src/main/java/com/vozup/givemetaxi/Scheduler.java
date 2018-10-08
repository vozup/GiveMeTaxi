package com.vozup.givemetaxi;

import com.vozup.givemetaxi.entities.DriverEntity;
import com.vozup.givemetaxi.entities.OrderEntity;
import com.vozup.givemetaxi.repository.DriverRepository;
import com.vozup.givemetaxi.repository.OrderRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class Scheduler {
    @Inject
    DriverRepository driverRepository;
    @Inject
    OrderRepository orderRepository;

    @Scheduled(initialDelay = 10000, fixedDelay = 5000)
    public void findFreeCar() {
        System.out.println("scheldure is started");
        DriverEntity driver = null;
        OrderEntity order = orderRepository.findFirstByReceivedIsFalse();
        if(order != null){
            driver = driverRepository.findFirstByBusyIsFalseAndCarCarTypeIs(order.getCarType());
        }else{
            System.out.println("No avaible order");
            return;
        }
        if (driver == null){
            System.out.println("No avaible cartype for order");
            return;
        }
        else {
            driver.addOrder(order);
            driver.setBusy(true);
            driverRepository.save(driver);

            order.setDriver(driver);
            order.setReceived(true);
            orderRepository.save(order);
        }
        System.out.println("scheldure is finished");
    }
}
