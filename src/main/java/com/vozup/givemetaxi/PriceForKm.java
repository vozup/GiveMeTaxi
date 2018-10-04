package com.vozup.givemetaxi;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
public class PriceForKm {
    private Map<CarType, Integer> priceForKm;

    @PostConstruct
    private void init(){
        priceForKm = new HashMap<>();
        priceForKm.put(CarType.STANDART, 10);
        priceForKm.put(CarType.BUISNESS, 20);
        priceForKm.put(CarType.UNIVERSAL, 20);
        priceForKm.put(CarType.COMFORT, 25);
        priceForKm.put(CarType.MICROBUS, 25);
    }

    public Integer priceForKm(String carType){
        if (carType != null){
            return priceForKm.get(CarType.valueOf(carType));
        }
        else return 0;
    }

    public Integer priceForKm(CarType carType){
        if (carType != null){
            return priceForKm.get(carType);
        }
        else return 0;
    }
}
