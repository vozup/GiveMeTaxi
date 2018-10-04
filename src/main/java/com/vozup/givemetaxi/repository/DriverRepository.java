package com.vozup.givemetaxi.repository;

import com.vozup.givemetaxi.entities.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<DriverEntity, Long> {

}
