package com.example.Registration.Models;

//import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
//import java.util.UUID;

@Component
@Entity
@Data
public class User {
    @Id
    @Column(name = "user_id")
    private int id;

    @Size(min=3, max=15)
    private String userName;

    @NotNull
    @Email(message = "Enter a Valid Email")
    private String email;

    @NotNull
    private String password;

    
}
