package com.OfBusiness.task.controller;


import com.OfBusiness.task.entity.Order;
import com.OfBusiness.task.entity.Product;
import com.OfBusiness.task.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PutMapping
    public Product addProduct(@RequestParam Long id, @RequestParam String name, @RequestParam Long quantity) {
        return productService.addOrUpdateProduct(id, name, quantity);
    }

    @GetMapping("/{id}/stockInHand")
    public Long getStock(@PathVariable Long id) {
        return productService.getStockQuantity(id);
    }

    @PostMapping("/{productId}/buyer/{buyerId}/order")
    public Order placeOrder(@PathVariable Long productId, @PathVariable Long buyerId, @RequestParam Long quantity) {
        return productService.placeOrder(productId, buyerId, quantity);
    }

    @GetMapping("/order")
    public List<Order> listOrders() {
        return productService.listOrders();
    }
}
