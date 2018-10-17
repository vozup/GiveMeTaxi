package com.vozup.givemetaxi.repository;

import com.vozup.givemetaxi.entities.DriverEntity;
import com.vozup.givemetaxi.enums.CarType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<DriverEntity, Long> {
    DriverEntity findFirstById(Long id);

    DriverEntity findFirstByBusyIs(boolean isBusy);
    DriverEntity findFirstByBusyIsFalseAndCarCarTypeIs(CarType carType);
    List<DriverEntity> findAllByBusyIsFalse();

    List<DriverEntity> findAllByBusyIsFalseAndCarIsNotNull();
}
