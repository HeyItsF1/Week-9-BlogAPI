package com.example.blogapi.Models;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class BlogUser extends BaseModel {

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
}
