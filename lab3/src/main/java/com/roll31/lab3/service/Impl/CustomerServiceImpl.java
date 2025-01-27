package com.roll31.lab3.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roll31.lab3.DAO.CustomerDetailsRepository;
import com.roll31.lab3.DTO.CustomerDetailsDTO;
import com.roll31.lab3.entity.CUST_DETAILS;
import com.roll31.lab3.service.CustomerService;
import com.roll31.lab3.service.Helper.CustomerServiceHelper;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerDetailsRepository customerDetailsRepository;
    @Autowired
    CustomerServiceHelper customerServiceHelper;

    @Override
    public CUST_DETAILS addCustomerDetails(CustomerDetailsDTO customerDetailsDTO)
    {
        CUST_DETAILS cust_DETAILS = customerServiceHelper.generateCust_DETAILS(customerDetailsDTO);
        customerDetailsRepository.save(cust_DETAILS);
        return cust_DETAILS;
    }
}
