package com.vozup.givemetaxi.repository;

import com.vozup.givemetaxi.entities.SiteManagersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteManagersRepository extends JpaRepository<SiteManagersEntity, Long> {
    SiteManagersEntity findByLogin(String login);
}
