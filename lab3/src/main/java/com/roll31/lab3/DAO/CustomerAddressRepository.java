package com.roll31.lab3.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roll31.lab3.entity.CUST_ADDRESS;

public interface CustomerAddressRepository extends JpaRepository<CUST_ADDRESS, Long>{
    
}
