package com.OfBusiness.task.controller;

import com.OfBusiness.task.entity.Buyer;
import com.OfBusiness.task.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/buyer")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @PutMapping
    public Buyer onboardBuyer(@RequestParam String name) {
        return buyerService.onboardBuyer(name);
    }
}
