package com.roll31.lab3.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roll31.lab3.entity.CUST_CL;

public interface CustomerClassificationRepository extends JpaRepository<CUST_CL, Long> {
    
}
