package com.vozup.givemetaxi;

import javax.inject.Named;

@Named
public class Operator {
    private long id = 1L;
    private String operatorLogin = "Default";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOperatorLogin() {
        return operatorLogin;
    }

    public void setOperatorLogin(String operatorLogin) {
        this.operatorLogin = operatorLogin;
    }
}
