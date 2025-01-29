package com.roll31.lab3.controller;

import com.roll31.lab3.DTO.CustomerDetailsDTO;
import com.roll31.lab3.DTO.TypeValue;
import com.roll31.lab3.entity.CUST_ADDRESS;
import com.roll31.lab3.entity.CUST_CL;
import com.roll31.lab3.entity.CUST_DETAILS;
import com.roll31.lab3.entity.CUST_ID;
import com.roll31.lab3.entity.CUST_POI;
import com.roll31.lab3.entity.User;
import com.roll31.lab3.service.CustomerService;
import com.roll31.lab3.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PostMapping("/addUsers")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    @PostMapping("/addCustomerDetails")
    public CUST_DETAILS createCustomer(@RequestBody CustomerDetailsDTO customerDetailDTO)
    {
       CUST_DETAILS cust_DETAILS = customerService.addCustomerDetails(customerDetailDTO);
       return cust_DETAILS;
    }
    @PostMapping("/addClassification")
    public CUST_CL createClassification(@RequestBody TypeValue nameTypeValue)
    {
        CUST_CL cust_cl = customerService.addClassification(nameTypeValue);
        return cust_cl;
    }
    @PostMapping("/addPOI/{id}")
    public CUST_POI createCust_POI(@PathVariable("id") Long id, @RequestBody TypeValue poiTypeValue )
    {
        CUST_POI cust_POI = customerService.addCust_POI(id, poiTypeValue);
        return cust_POI;
    }

    @PostMapping("/addIdentification/{id}")
    public CUST_ID createCust_Id(@PathVariable("id") Long id, @RequestBody TypeValue IdTypeValue)
    {
        CUST_ID cust_ID = customerService.addCust_ID(id, IdTypeValue);
        return cust_ID;
    }

    @PostMapping("/addAddress/{id}")
    public CUST_ADDRESS createCust_ADDRESS(@PathVariable("id") Long id, @RequestBody TypeValue AddresstypeValue)
    {
        CUST_ADDRESS cust_ADDRESS = customerService.addCust_Address(id, AddresstypeValue);
        return cust_ADDRESS;
    }
}