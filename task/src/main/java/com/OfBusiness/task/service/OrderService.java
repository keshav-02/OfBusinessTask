package com.OfBusiness.task.service;

import com.OfBusiness.task.entity.Order;

import java.util.List;

public interface OrderService {
    Order placeOrder(Long productId, Long buyerId, int quantity);

    List<Order> listOrders();
}

