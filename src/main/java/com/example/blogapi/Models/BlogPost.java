package com.example.blogapi.Models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@Table
public class BlogPost extends BaseModel{
    private String postTitle;
    private String postBody;
//    @CreatedDate
//    private LocalDate dateCreated;
    private Instant createdDate;
  @ManyToOne
 // @JoinColumn(name = "id")
    private BlogUser blogUser;
}
