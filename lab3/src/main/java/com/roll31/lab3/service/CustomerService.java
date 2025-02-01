package com.roll31.lab3.service;


import com.roll31.lab3.DTO.CustomerDetailsDTO;
import com.roll31.lab3.DTO.NameTypeValue;
import com.roll31.lab3.entity.CUST_CL;
import com.roll31.lab3.entity.CUST_DETAILS;

public interface CustomerService {
    CUST_DETAILS addCustomerDetails(CustomerDetailsDTO customerDetailsDTO);
    CUST_CL addClassification(NameTypeValue nameTypeValue);
}
