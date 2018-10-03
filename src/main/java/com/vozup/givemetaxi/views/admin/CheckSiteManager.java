package com.vozup.givemetaxi.views.admin;

import com.vozup.givemetaxi.entities.OperatorEntity;
import com.vozup.givemetaxi.entities.SiteManagersEntity;
import com.vozup.givemetaxi.repository.SiteManagersRepository;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;

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
            if (siteManagersEntity != null){
                if (siteManagersEntity.getLogin().equals(login) && siteManagersEntity.getPassword().equals(password)){
                    return "goToSiteManagerHomePage";
                }
            }
        }
        showMessage("Login or password are incorect!");
        resetLoginAndPasswordFields();
        return null;
    }

    private void showMessage(String message){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }

    private void resetLoginAndPasswordFields(){
        this.login = "";
        this.password = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
