package com.lab7.UI_Test;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Page<User> getPaginatedUsers(int page, int pageSize)
    {
        return userRepository.findAll(PageRequest.of(page, pageSize));
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public void saveUser(User user)
    {
        userRepository.save(user);
    }
    
    public void deleteById(Long id)
    {
        if (userRepository.existsById(id))
        {
            userRepository.deleteById(id);
        }
        else
        {
            throw new ResoruceNotFoundException("User doesnt exist!");
        }
    }

    public Page<User> findPaginated(int page, int size)
    {
        PageRequest pageable = PageRequest.of(page - 1, size);
        Page<User> usersPage = userRepository.findAll(pageable);
        return (usersPage);
    }

    public void updateUser(Long id, User user)
    {
        User existingUser = userRepository.findById(id).orElseThrow(()-> new ResoruceNotFoundException("User not found"));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        userRepository.save(existingUser);
    }

    public User findById(Long id)
    {
        return userRepository.findById(id).orElseThrow(()->new ResoruceNotFoundException("User not found"));
    }
}
