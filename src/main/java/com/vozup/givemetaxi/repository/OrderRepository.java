package com.vozup.givemetaxi.repository;

import com.vozup.givemetaxi.CarType;
import com.vozup.givemetaxi.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    OrderEntity findFirstByReceivedIsFalseAndCarTypeEquals(CarType carType);
    OrderEntity findFirstByReceivedIsFalse();
}
