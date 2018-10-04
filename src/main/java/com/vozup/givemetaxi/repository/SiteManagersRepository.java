package com.vozup.givemetaxi.repository;

import com.vozup.givemetaxi.entities.SiteManagersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SiteManagersRepository extends JpaRepository<SiteManagersEntity, Long> {
    SiteManagersEntity findByLogin(String login);

    @Modifying
    @Query("UPDATE SiteManagersEntity sm SET sm.login=:login, sm.password=:password, " +
            "sm.name=:name, sm.lastName=:lastName WHERE sm.id=:id")
    void updateSiteManagersEntity(@Param("id") Long id,
                                  @Param("login") String login,
                                  @Param("password") String password,
                                  @Param("name") String name,
                                  @Param("lastName") String lastName);
}
