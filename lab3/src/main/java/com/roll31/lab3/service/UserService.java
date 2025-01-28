package com.roll31.lab3.service;

import java.util.List;

import com.roll31.lab3.DAO.UserRepository;
import com.roll31.lab3.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}