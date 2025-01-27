package com.roll31.lab3.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roll31.lab3.entity.CUST_DETAILS;

public interface CustomerDetailsRepository extends JpaRepository<CUST_DETAILS, Long> {
    
}
