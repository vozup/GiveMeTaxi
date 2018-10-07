package com.vozup.givemetaxi.repository;

import com.vozup.givemetaxi.entities.Log4jEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogsRepository extends JpaRepository<Log4jEntity, String> {
}
