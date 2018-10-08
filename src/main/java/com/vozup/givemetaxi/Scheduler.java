package com.vozup.givemetaxi;

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

    @Scheduled(fixedDelay = 5000)
    public void findFreeCar() {

    }
}
