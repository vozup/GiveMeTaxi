package com.vozup.givemetaxi.repository;

import com.vozup.givemetaxi.entities.OperatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OperatorRepository extends JpaRepository<OperatorEntity, Long> {
    OperatorEntity findByLogin(String login);
    @Modifying
    @Query("UPDATE OperatorEntity operator SET " +
            "operator.id=:id," +
            "operator.login=:login, " +
            "operator.password=:password," +
            "operator.name=:name," +
            "operator.lastName=:lastname")
    void updateOperator(@Param("id") Long id,
                        @Param("login") String login,
                        @Param("password") String password,
                        @Param("name") String name,
                        @Param("lastname") String lastname);
}
