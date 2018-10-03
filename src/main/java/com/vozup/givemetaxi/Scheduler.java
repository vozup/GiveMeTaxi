package com.vozup.givemetaxi;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Scheduled(fixedDelay = 1000)
    public void test() {
        //System.out.println(22222);
    }
}
