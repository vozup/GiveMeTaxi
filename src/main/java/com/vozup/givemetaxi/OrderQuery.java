package com.vozup.givemetaxi;

import com.vozup.givemetaxi.entities.OrderEntity;
import com.vozup.givemetaxi.repository.OrderRepository;
import com.vozup.givemetaxi.views.operator.TakeOrder;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class OrderQuery {
    private OrderEntity selectedOrder;
    private List<OrderEntity> orderList;

    @Inject
    private OrderRepository repository;

    @PostConstruct
    void init(){
        orderList = repository.findAll();
    }

    public void addOrder(OrderEntity order){
        orderList.add(order);
    }

    public List<OrderEntity> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderEntity> orderList) {
        this.orderList = orderList;
    }

    public OrderEntity getSelectedOrder() {
        return selectedOrder;
    }

    public void setSelectedOrder(OrderEntity selectedOrder) {
        this.selectedOrder = selectedOrder;
    }
}
