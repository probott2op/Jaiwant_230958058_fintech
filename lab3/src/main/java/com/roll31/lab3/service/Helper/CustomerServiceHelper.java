package com.roll31.lab3.service.Helper;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Component;

import com.roll31.lab3.DTO.CustomerDetailsDTO;
import com.roll31.lab3.DTO.NameTypeValue;
import com.roll31.lab3.entity.CUST_DETAILS;

@Component
public class CustomerServiceHelper {
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
        cust_DETAILS.setContact(customerDetailsDTO.getContact());
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
        // returning the now filled CUST_DETAILS entity object
        return cust_DETAILS;
    }
    // sets the audit logs
    public void setAuditLog(CUST_DETAILS cust_DETAILS)
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
