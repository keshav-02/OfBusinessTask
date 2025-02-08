package com.OfBusiness.task.repository;

import com.OfBusiness.task.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerDAO extends JpaRepository<Buyer, Long> {
}
