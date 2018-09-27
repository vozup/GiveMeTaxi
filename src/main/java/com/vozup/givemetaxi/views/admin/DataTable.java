package com.vozup.givemetaxi.views.admin;

import com.vozup.givemetaxi.repository.OperatorRepository;
import com.vozup.givemetaxi.repository.OrderRepository;
import com.vozup.givemetaxi.repository.SiteManagersRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class DataTable {
    @Inject
    OperatorRepository operatorRepository;
    @Inject
    OrderRepository orderRepository;
    @Inject
    SiteManagersRepository siteManagersRepository;
    //
    public void takeOrderTable(){

    }
}
