package com.example.java_sample.repository;

import java.util.Optional;

import com.example.java_sample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {
    Optional<User> findByPhoneNumber(String phoneNumber);
}
