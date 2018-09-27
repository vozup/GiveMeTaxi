package com.vozup.givemetaxi.views.operator;

import com.vozup.givemetaxi.entities.OperatorEntity;
import com.vozup.givemetaxi.repository.OperatorRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CheckOperator {
    @Inject
    private OperatorRepository repository;

    private String name;
    private String lastName;
    private String login;
    private String password;

    public String checkPassword() {
        if (login != null && password != null) {
            OperatorEntity operatorEntity = repository.findByLogin(this.login);

            if (operatorEntity.getLogin().equals(login) && operatorEntity.getPassword().equals(password)){
                System.out.println();
                return "goToOperatorHomePage";
            }
        }
        return "goToInvalidPasswordPage";
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
