package com.roll31.lab3.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roll31.lab3.DAO.CustomerClassificationRepository;
import com.roll31.lab3.DAO.CustomerDetailsRepository;
import com.roll31.lab3.DAO.CustomerNameRepository;
import com.roll31.lab3.DTO.CustomerDetailsDTO;
import com.roll31.lab3.DTO.NameTypeValue;
import com.roll31.lab3.entity.CUST_CL;
import com.roll31.lab3.entity.CUST_DETAILS;
import com.roll31.lab3.entity.CUST_NAME;
import com.roll31.lab3.service.CustomerService;
import com.roll31.lab3.service.Helper.CustomerServiceHelper;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerDetailsRepository customerDetailsRepository;
    @Autowired
    CustomerClassificationRepository customerClassificationRepository;
    @Autowired
    CustomerServiceHelper customerServiceHelper;
    @Autowired
    CustomerNameRepository customerNameRepository;

    @Override
    public CUST_DETAILS addCustomerDetails(CustomerDetailsDTO customerDetailsDTO)
    {
        CUST_DETAILS cust_DETAILS = customerServiceHelper.generateCust_DETAILS(customerDetailsDTO);
        customerDetailsRepository.save(cust_DETAILS);
        addName(cust_DETAILS, customerDetailsDTO.getCustomerFullName());
        return cust_DETAILS;
    }

    @Override
    public CUST_CL addClassification(NameTypeValue nameTypeValue)
    {
        CUST_CL cust_CL = customerServiceHelper.generateCust_CL(nameTypeValue);
        customerClassificationRepository.save(cust_CL);
        return cust_CL;
    }

    public void addName(CUST_DETAILS cust_DETAILS, List<NameTypeValue> nameParts)
    {
        for (NameTypeValue namepart: nameParts)
        {
            CUST_NAME cust_NAME = customerServiceHelper.generateCust_NAME(cust_DETAILS, namepart);
            customerNameRepository.save(cust_NAME);
        }
    }
}
