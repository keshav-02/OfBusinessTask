package com.OfBusiness.task.service.impl;

import com.OfBusiness.task.entity.Buyer;
import com.OfBusiness.task.entity.Order;
import com.OfBusiness.task.entity.Product;
import com.OfBusiness.task.repository.BuyerDAO;
import com.OfBusiness.task.repository.OrderDAO;
import com.OfBusiness.task.repository.ProductDAO;
import com.OfBusiness.task.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private BuyerDAO buyerDAO;

    @Autowired
    private OrderDAO orderDAO;


    @Override
    public Product addOrUpdateProduct(Long id, String name, Long quantity) {
        Product product;
        Optional<Product> existingProduct = productDAO.findById(id);

        if (existingProduct.isPresent()) {
            product = existingProduct.get();
            product.setQuantity(product.getQuantity() + quantity);
        } else {
            product = new Product();
            product.setProductName(name);
            product.setQuantity(quantity);
        }
        return productDAO.save(product);
    }

    @Override
    public Long getStockQuantity(Long id) {
        return productDAO.findById(id)
                .map(Product::getQuantity)
                .orElse(0L);
    }

    @Override
    public Order placeOrder(Long productId, Long buyerId, Long quantity) {
        Optional<Product> productOpt = productDAO.findById(productId);
        Optional<Buyer> buyerOpt = buyerDAO.findById(buyerId);

        if (productOpt.isPresent() && buyerOpt.isPresent()) {
            Product product = productOpt.get();
            if (product.getQuantity() >= quantity) {
                product.setQuantity(product.getQuantity() - quantity);
                productDAO.save(product);

                Order order = new Order();
                order.setProduct(product);
                order.setQuantity(quantity);
                order.setBuyer(buyerOpt.get());

                return orderDAO.save(order);
            }
        }
        return null;
    }

    @Override
    public List<Order> listOrders() {
        return orderDAO.findAll();
    }
}
