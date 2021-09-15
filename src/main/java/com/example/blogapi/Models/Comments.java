package com.example.blogapi.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Comments extends BaseModel{
    private String commentBody;
    @ManyToOne
   // @JoinColumn(name = "id")
    private BlogPost blogPost;
    @ManyToOne
  //  @JoinColumn(name = "id")
    private BlogUser blogUser;
}
