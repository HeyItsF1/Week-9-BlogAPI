package com.example.blogapi.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Vote extends BaseModel {

    private VoteTYpe voteType;
    @ManyToOne
    //@JoinColumn(name = "id")
    private BlogUser blogUser;
    @ManyToOne
    //@JoinColumn(name = "id")
    private BlogPost blogPost;

}
