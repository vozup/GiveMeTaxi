package com.vozup.givemetaxi.repository;

import com.vozup.givemetaxi.entities.OrderEntity;
import com.vozup.givemetaxi.enums.CarType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    OrderEntity findFirstByReceivedIsFalseAndCarTypeEquals(CarType carType);
    OrderEntity findFirstByReceivedIsFalse();
    //List<OrderEntity> findAllByTimeHours(Integer hour);
}
