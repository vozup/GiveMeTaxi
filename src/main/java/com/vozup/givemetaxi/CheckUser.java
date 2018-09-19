package com.vozup.givemetaxi;

import com.vozup.givemetaxi.entityes.Operator;
import com.vozup.givemetaxi.repository.OperatorRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CheckUser {
    @Inject
    private OperatorRepository repository;

    private String name;
    private String lastName;
    private String login;
    private String password;

    public String checkPassword() {
        if (login != null && password != null) {
            Operator operator = repository.findByLogin(this.login);

            if (operator.getLogin().equals(login) && operator.getPassword().equals(password)){
                return "goToHomePage";
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
