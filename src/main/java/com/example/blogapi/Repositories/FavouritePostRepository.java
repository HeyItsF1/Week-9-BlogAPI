package com.example.blogapi.Repositories;

import com.example.blogapi.Models.FavouritePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouritePostRepository extends JpaRepository<FavouritePost, Long> {
}
