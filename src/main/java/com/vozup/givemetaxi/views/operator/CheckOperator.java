package com.vozup.givemetaxi.views.operator;

import com.vozup.givemetaxi.entities.OperatorEntity;
import com.vozup.givemetaxi.repository.OperatorRepository;
import com.vozup.givemetaxi.views.admin.CheckSiteManager;
import org.apache.log4j.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CheckOperator {
    private static final Logger LOGGER = Logger.getLogger(CheckOperator.class);
    @Inject
    private OperatorRepository repository;
    OperatorEntity operatorEntity;

    private String name;
    private String lastName;
    private String login;
    private String password;

    public String checkPassword() {
        if (login != null && password != null) {
            operatorEntity = repository.findByLogin(this.login);

            if (operatorEntity.getLogin().equals(login) && operatorEntity.getPassword().equals(password)){
                LOGGER.info("Sign in :" + login);
                return "goToOperatorHomePage";
            }
        }
        LOGGER.error("Incorrect Login or Password when sign in");
        showMessage("Login or password are incorect!");
        resetLoginAndPasswordFields();
        return null;
    }

    private void resetLoginAndPasswordFields(){
        this.login = "";
        this.password = "";
    }

    private void showMessage(String message){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }

    public OperatorEntity getOperatorEntity() {
        return operatorEntity;
    }

    public void setOperatorEntity(OperatorEntity operatorEntity) {
        this.operatorEntity = operatorEntity;
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
