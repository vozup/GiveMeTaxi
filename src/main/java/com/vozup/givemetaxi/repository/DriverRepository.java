package com.vozup.givemetaxi.repository;

import com.vozup.givemetaxi.CarType;
import com.vozup.givemetaxi.entities.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<DriverEntity, Long> {
    DriverEntity findFirstByBusyIsFalse();
    DriverEntity findFirstByBusyIsFalseAndCarCarTypeIs(CarType carType);
    List<DriverEntity> findAllByBusyIsFalse();

}
