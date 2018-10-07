package com.vozup.givemetaxi.repository;

import com.vozup.givemetaxi.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
}
