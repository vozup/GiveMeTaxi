package com.vozup.givemetaxi.repository;

import com.vozup.givemetaxi.entityes.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorRepository extends JpaRepository<Operator, Long> {
    Operator findByLogin(String login);
}
