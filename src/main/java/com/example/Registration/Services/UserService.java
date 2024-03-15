package com.example.Registration.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Registration.Models.User;
import com.example.Registration.Repositories.UserRepo;
@Service
public class UserService {

    @Autowired
    private UserRepo userrepo;

    public User createUser(User user)
    {
        return userrepo.save(user);
    }   
    
    public Optional<User> getUserByID(Integer id)
    {
        return userrepo.findById(id);
    }

    public List<User> getAllUsers() {
        return userrepo.findAll();
    }

    public void updateUser(Integer id, User userDetails) {
        userrepo.findById(id).ifPresent(presentDetails -> {
        presentDetails.setUserName(userDetails.getUserName());
        presentDetails.setEmail(userDetails.getEmail());
        presentDetails.setPassword(userDetails.getPassword());
        userrepo.save(presentDetails);
    });
}
    public void deleteUser(int id) {
        userrepo.deleteById(id);
    }

}