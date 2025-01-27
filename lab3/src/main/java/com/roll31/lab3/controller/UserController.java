package com.roll31.lab3.controller;

import com.roll31.lab3.DTO.CustomerDetailsDTO;
import com.roll31.lab3.entity.CUST_DETAILS;
import com.roll31.lab3.entity.User;
import com.roll31.lab3.service.CustomerService;
// import com.roll31.lab3.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    /*@Autowired
    private UserService userService;*/
    @Autowired
    private CustomerService customerService;

    /*@GetMapping("/getUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PostMapping("/addUsers")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }*/
    @PostMapping("/addCustomerDetails")
    public CUST_DETAILS createCustomer(@RequestBody CustomerDetailsDTO customerDetailDTO)
    {
       CUST_DETAILS cust_DETAILS = customerService.addCustomerDetails(customerDetailDTO);
       return cust_DETAILS;
    }
}