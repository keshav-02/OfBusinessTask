package com.OfBusiness.task.service;

import com.OfBusiness.task.entity.Order;
import com.OfBusiness.task.entity.Product;

import java.util.List;

public interface ProductService {
    Product addOrUpdateProduct(Long id, String name, Long quantity);

    Long getStockQuantity(Long id);

    Order placeOrder(Long productId, Long buyerId, Long quantity);

    List<Order> listOrders();
}
