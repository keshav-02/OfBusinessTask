package com.OfBusiness.task.service.impl;

import com.OfBusiness.task.entity.Buyer;
import com.OfBusiness.task.repository.BuyerDAO;
import com.OfBusiness.task.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private BuyerDAO buyerDAO;

    @Override
    public Buyer onboardBuyer(String name) {
        Buyer buyer = new Buyer();
        buyer.setBuyerName(name);
        return buyerDAO.save(buyer);
    }
}
