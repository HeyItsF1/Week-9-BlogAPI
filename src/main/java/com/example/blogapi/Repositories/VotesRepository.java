package com.example.blogapi.Repositories;

import com.example.blogapi.Models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotesRepository extends JpaRepository<Vote, Long> {
}
