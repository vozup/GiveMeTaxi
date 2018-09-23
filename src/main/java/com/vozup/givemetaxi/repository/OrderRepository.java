package com.vozup.givemetaxi.repository;

import com.vozup.givemetaxi.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
