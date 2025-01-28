package com.roll31.lab3.service.Helper;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roll31.lab3.DAO.CustomerClassificationRepository;
import com.roll31.lab3.DTO.CustomerDetailsDTO;
import com.roll31.lab3.DTO.NameTypeValue;
import com.roll31.lab3.entity.AuditLoggable;
import com.roll31.lab3.entity.CUST_CL;
import com.roll31.lab3.entity.CUST_DETAILS;
import com.roll31.lab3.entity.CUST_NAME;

// One major improvement I want to do here is that,
// When you give first name , last name in Type value
// I want to validate it with the CUST_CLS table and fetch 
// cls Id from there
// Also I want to rename NameTypeValue to TypeValue since it
// is being reused

@Component
public class CustomerServiceHelper {
    @Autowired
    CustomerClassificationRepository customerClassificationRepository;

    public CUST_DETAILS generateCust_DETAILS(CustomerDetailsDTO customerDetailsDTO)
    {
        CUST_DETAILS cust_DETAILS = new CUST_DETAILS();

        // transferring the type from DTO to Entity object
        cust_DETAILS.setType(customerDetailsDTO.getType());
        // transferring dob
        cust_DETAILS.setDob(customerDetailsDTO.getDob());
        // transferring status
        cust_DETAILS.setStatus(customerDetailsDTO.getStatus());
        // transferring mobile
        cust_DETAILS.setMobile(customerDetailsDTO.getMobile());
        // transferring contact
        // cust_DETAILS.setContact(customerDetailsDTO.getContact());
        // transferring email
        cust_DETAILS.setEmail(customerDetailsDTO.getEmail());
        // transferring country
        cust_DETAILS.setCountry(customerDetailsDTO.getCountry());
        // transferring the name
        StringBuilder fullNameBuilder = new StringBuilder();
        List<NameTypeValue> nameParts = customerDetailsDTO.getCustomerFullName();
        for (NameTypeValue namePart: nameParts)
        {
            fullNameBuilder.append(namePart.getNameValue());
            fullNameBuilder.append(" ");
        }
        String fullName = fullNameBuilder.toString().trim();
        cust_DETAILS.setFullName(fullName);
        // setting CRUD value
        cust_DETAILS.setCrud_value('C');

        // setting the audit log
        setAuditLog(cust_DETAILS);

        // create a list of CUST_NAME objects
        /*List<CUST_NAME> cust_NAME_list = generateCust_NAME(cust_DETAILS, nameParts);
        //setting the one to many relationship
        cust_DETAILS.setCust_NAME(cust_NAME_list);*/

        // returning the now filled CUST_DETAILS entity object
        return cust_DETAILS;
    }
    public CUST_CL generateCust_CL(NameTypeValue nameTypeValue)
    {
        CUST_CL cust_CL = new CUST_CL();

        // transferring the type from DTO to Entity object
        // Setting the classification type
        cust_CL.setType(nameTypeValue.getNameType());
        // setting the classification value
        cust_CL.setTypeValue(nameTypeValue.getNameValue());
        setAuditLog(cust_CL);
        return cust_CL;
    }

    // when given the List of name parts it creates a List of CUST_NAME objects
    public CUST_NAME generateCust_NAME(CUST_DETAILS cust_DETAILS, NameTypeValue namePart)
    {
        CUST_NAME cust_NAME = new CUST_NAME();
        // Setting the type and value, which is many to one
        CUST_CL cust_CL = customerClassificationRepository.findByType(namePart.getNameType());
        cust_NAME.setCust_CL(cust_CL);
        cust_NAME.setValue(namePart.getNameValue());
        // setting the relationship , which is many to one
        cust_NAME.setCust_DETAILS(cust_DETAILS);
        // setting CRUD value
        cust_NAME.setCrud_value('C');
        // setting audit log
        setAuditLog(cust_NAME);
        return cust_NAME;
    }

    // sets the audit logs(for all since they implement the interface)
    public <T extends AuditLoggable>void setAuditLog(T cust_DETAILS)
    {
        cust_DETAILS.setEfctv_date(new Date(System.currentTimeMillis()));
        cust_DETAILS.setLocal_ts(new Timestamp(System.currentTimeMillis()));
        cust_DETAILS.setHost_ts(new Timestamp(System.currentTimeMillis()));
        cust_DETAILS.setAcpt_ts(new Timestamp(System.currentTimeMillis()));
        cust_DETAILS.setAcpt_ts_utc_ofst(new Timestamp(System.currentTimeMillis()));
        cust_DETAILS.setWs_id("Mac Jaiwant");
        cust_DETAILS.setUser_id("Jaiwant");
        cust_DETAILS.setPrgm_id("Java prgm 1");
    }
}
