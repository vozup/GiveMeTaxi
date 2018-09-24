package com.vozup.givemetaxi.views;

import com.vozup.givemetaxi.entities.OperatorEntity;
import com.vozup.givemetaxi.entities.SiteManagersEntity;
import com.vozup.givemetaxi.repository.SiteManagersRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CheckSiteManager {
    @Inject
    private SiteManagersRepository repository;

    private String name;
    private String lastName;
    private String login;
    private String password;

    public String checkPassword() {
        if (login != null && password != null) {
            SiteManagersEntity siteManagersEntity = repository.findByLogin(this.login);

            if (siteManagersEntity.getLogin().equals(login) && siteManagersEntity.getPassword().equals(password)){
                System.out.println();
                return "goToSiteManagerHomePage";
            }
        }
        return "goToInvalidPasswordPage";
    }
}
