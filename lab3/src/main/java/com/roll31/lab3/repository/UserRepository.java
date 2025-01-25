package com.roll31.lab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.roll31.lab3.entity.User;
public interface UserRepository extends JpaRepository<User, Long> {
}
