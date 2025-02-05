package com.roll31.lab3.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.roll31.lab3.DAO.CustomerAddressRepository;
import com.roll31.lab3.DAO.CustomerClassificationRepository;
import com.roll31.lab3.DAO.CustomerDetailsRepository;
import com.roll31.lab3.DAO.CustomerIdRepository;
import com.roll31.lab3.DAO.CustomerNameRepository;
import com.roll31.lab3.DAO.CustomerPoiRepository;
import com.roll31.lab3.DTO.CustomerDetailsDTO;
import com.roll31.lab3.DTO.CustomerPoiDTO;
import com.roll31.lab3.DTO.TypeValue;
import com.roll31.lab3.entity.CUST_ADDRESS;
import com.roll31.lab3.entity.CUST_CL;
import com.roll31.lab3.entity.CUST_DETAILS;
import com.roll31.lab3.entity.CUST_ID;
import com.roll31.lab3.entity.CUST_NAME;
import com.roll31.lab3.entity.CUST_POI;
import com.roll31.lab3.entity.CUST_SIGNIN;
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
    @Autowired
    CustomerAddressRepository customerAddressRepository;
    @Autowired
    CustomerPoiRepository customerPoiRepository;
    @Autowired
    CustomerIdRepository customerIdRepository;

    @Override
    public CUST_DETAILS addCustomerDetails(CustomerDetailsDTO customerDetailsDTO)
    {
        CUST_DETAILS cust_DETAILS = customerServiceHelper.generateCust_DETAILS(customerDetailsDTO);
        customerDetailsRepository.save(cust_DETAILS);
        addName(cust_DETAILS, customerDetailsDTO.getCustomerFullName());
        addId(cust_DETAILS);
        addAddress(cust_DETAILS, customerDetailsDTO.getCustomerFullAddress());
        return cust_DETAILS;
    }

    @Override
    public CUST_CL addClassification(TypeValue nameTypeValue)
    {
        CUST_CL cust_CL = customerServiceHelper.generateCust_CL(nameTypeValue);
        customerClassificationRepository.save(cust_CL);
        return cust_CL;
    }

    @Override
    public CUST_POI addCust_POI(Long id, CustomerPoiDTO customerPoiDTO)
    {
        Optional<CUST_DETAILS> cust_DETAILS =  customerDetailsRepository.findById(id);
        CUST_POI cust_POI = customerServiceHelper.generateCust_POI(cust_DETAILS, customerPoiDTO);
        customerPoiRepository.save(cust_POI);
        return cust_POI;
    }

    @Override
    public CUST_ID addCust_ID(Long id, TypeValue IdTypeValue)
    {
        Optional<CUST_DETAILS> cust_DETAILS = customerDetailsRepository.findById(id);
        CUST_ID cust_ID = customerServiceHelper.generateCust_ID(cust_DETAILS, IdTypeValue);
        customerIdRepository.save(cust_ID);
        return cust_ID;
    }

    @Override
    public CUST_ADDRESS addCust_Address(Long id, TypeValue AddressTypeValue)
    {
        Optional<CUST_DETAILS> cust_DETAILS = customerDetailsRepository.findById(id);
        CUST_ADDRESS cust_ADDRESS = customerServiceHelper.generateCust_ADDRESS(cust_DETAILS, AddressTypeValue);
        customerAddressRepository.save(cust_ADDRESS);
        return cust_ADDRESS;
    }

    @Override
    public CUST_SIGNIN addSignIn(Long id, TypeValue userPassTypeValue)
    {
        Optional<CUST_DETAILS> cust_DETAILS = customerDetailsRepository.findById(id);
        if (cust_DETAILS.isPresent())
        {
            CUST_SIGNIN cust_SIGNIN = new CUST_SIGNIN();
            cust_SIGNIN.setCust_DETAILS(cust_DETAILS.get());
            final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
            cust_SIGNIN.setPassword(encoder.encode(userPassTypeValue.getValue()));
            cust_SIGNIN.setUserName(userPassTypeValue.getType());
            customerServiceHelper.setAuditLog(cust_SIGNIN);
            return cust_SIGNIN;
        }
        return null;
    }

    public void addId(CUST_DETAILS cust_DETAILS)
    {
        TypeValue mobileTypeValue = new TypeValue();
        mobileTypeValue.setType("mobile");
        mobileTypeValue.setValue(cust_DETAILS.getMobile());
        CUST_ID mobileId = customerServiceHelper.generateCust_ID(Optional.of(cust_DETAILS), mobileTypeValue);
        customerIdRepository.save(mobileId);

        TypeValue emaiTypeValue = new TypeValue();
        emaiTypeValue.setType("email");
        emaiTypeValue.setValue(cust_DETAILS.getEmail());
        CUST_ID emailId = customerServiceHelper.generateCust_ID(Optional.of(cust_DETAILS), emaiTypeValue);
        customerIdRepository.save(emailId);
    }

    public void addName(CUST_DETAILS cust_DETAILS, List<TypeValue> nameParts)
    {
        for (TypeValue namepart: nameParts)
        {
            CUST_NAME cust_NAME = customerServiceHelper.generateCust_NAME(cust_DETAILS, namepart);
            customerNameRepository.save(cust_NAME);
        }
    }

    public void addAddress(CUST_DETAILS cust_DETAILS, List<TypeValue> address)
    {
        for (TypeValue territory: address)
        {
            CUST_ADDRESS cust_ADDRESS = customerServiceHelper.generateCust_ADDRESS(Optional.of(cust_DETAILS), territory);
            customerAddressRepository.save(cust_ADDRESS);
        }
    }
}
