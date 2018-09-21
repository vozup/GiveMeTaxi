package com.vozup.givemetaxi.repository;

import com.vozup.givemetaxi.entities.OperatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorRepository extends JpaRepository<OperatorEntity, Long> {
    OperatorEntity findByLogin(String login);
}
