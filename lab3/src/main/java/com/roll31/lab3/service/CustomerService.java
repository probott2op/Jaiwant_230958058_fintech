package com.roll31.lab3.service;


import com.roll31.lab3.DTO.CustomerDetailsDTO;
import com.roll31.lab3.DTO.TypeValue;
import com.roll31.lab3.entity.CUST_ADDRESS;
import com.roll31.lab3.entity.CUST_CL;
import com.roll31.lab3.entity.CUST_DETAILS;
import com.roll31.lab3.entity.CUST_ID;
import com.roll31.lab3.entity.CUST_POI;

public interface CustomerService {
    CUST_DETAILS addCustomerDetails(CustomerDetailsDTO customerDetailsDTO);
    CUST_CL addClassification(TypeValue nameTypeValue);
    CUST_POI addCust_POI(Long id, TypeValue poiTypeValue);
    CUST_ID addCust_ID(Long id, TypeValue IdTypeValue);
    CUST_ADDRESS addCust_Address(Long id, TypeValue AddressTypeValue);
}
