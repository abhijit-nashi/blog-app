package com.example.Registration.Controller;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Registration.Models.User;
import com.example.Registration.Services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

//@Autowired
private UserService userService;

@GetMapping
public List<User> getALLUsers()
{
    return userService.getAllUsers();
}

@GetMapping("/{id}")
public ResponseEntity<User> getUserById(@PathVariable Integer id)
{
    return userService.getUserByID(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
}

@PostMapping
public ResponseEntity<User> createUser(@RequestBody User user)
{
    User addeduser = userService.createUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(addeduser);
}

@PutMapping("/{id}")
public ResponseEntity<User> updateBook(@PathVariable Integer id, @RequestBody User updatedUser) {
     userService.updateUser(id, updatedUser);
     return ResponseEntity.noContent().build();
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteBook(@PathVariable Integer id)
{
    userService.deleteUser(id);
    return ResponseEntity.ok().build();
}

}
