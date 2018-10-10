package com.vozup.givemetaxi;

import com.vozup.givemetaxi.entities.OrderEntity;
import com.vozup.givemetaxi.repository.OrderRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class OrderQuery {
    private OrderEntity selectedOrder;
    private List<OrderEntity> orderList;

    @Inject
    private OrderRepository repository;

    public List<OrderEntity> getOrderList() {
        orderList = repository.findAll();
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
