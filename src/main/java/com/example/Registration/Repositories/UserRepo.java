package com.example.Registration.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Registration.Models.User;

public interface UserRepo extends JpaRepository<User, Integer> {

    
} 