package com.example.blogapi.Services;

import com.example.blogapi.Dto.UserDto;
import com.example.blogapi.Models.BlogPost;
import com.example.blogapi.Models.BlogUser;
import com.example.blogapi.Models.Comments;
import com.example.blogapi.Models.FavouritePost;

import java.util.List;

public interface BlogUserService {
      String addNewUser(BlogUser blogUser);
     Boolean login(UserDto userDto);
      BlogPost makeNewBlogPost(BlogPost blogPost);
      String addToFavouritesPost(FavouritePost favouritePost);
      List<BlogUser> getAllBlogUsers ();
      String getFavouriteBlogPost();
      Comments makeNewcomment(Comments comments);
      List<BlogPost> getAllBlogPost();
     // void deactivateBlogUser(String blogUserUsername);
     String deactivateBlogUser(BlogUser blogUser);
}
