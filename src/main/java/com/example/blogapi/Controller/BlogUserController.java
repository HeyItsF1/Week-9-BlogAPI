package com.example.blogapi.Controller;


import com.example.blogapi.Dto.UserDto;
import com.example.blogapi.Models.BlogPost;
import com.example.blogapi.Models.BlogUser;
import com.example.blogapi.Models.Comments;
import com.example.blogapi.Models.FavouritePost;
import com.example.blogapi.Services.ServicesImpl.BlogUserServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping(path = "api/v1/Blog")

public class BlogUserController {
    @Autowired
    private final BlogUserServicesImpl blogUserServices;

    @PostMapping("/register")
        public ResponseEntity<String> registerNewUser(@RequestBody BlogUser blogUser){
           return ResponseEntity.ok(blogUserServices.addNewUser(blogUser));
        }

        @PostMapping("/login")
        public ResponseEntity<String> login(UserDto userDto) {
            blogUserServices.login(userDto);
            return new ResponseEntity<>("Successfully signed in", HttpStatus.OK);
        }

        @PostMapping("/newblogpost")
            public void newblogpost(BlogPost blogpost) {
            blogUserServices.makeNewBlogPost(blogpost);
        }

    @PostMapping("/newComments")
    public void newcomment(Comments comments) {
        blogUserServices.makeNewcomment(comments);
    }

        @PostMapping("/addtofavorite")
        public void addtofavorites(FavouritePost favouritePost) {
            blogUserServices.addToFavouritesPost(favouritePost);
        }

        @GetMapping("/getBlogUsers")

        public List<BlogUser> getBlogUsers (){
            return blogUserServices.getAllBlogUsers();
        }

        @GetMapping("/getFavouriteBlogPost")
        public void getFavouriteBlogPost (){
            blogUserServices.getFavouriteBlogPost();
        }

    @GetMapping("/getAllBlogPost")

    public List<BlogPost> getBlogPost (){
        return blogUserServices.getAllBlogPost();
    }

//    @DeleteMapping(path = "{blogUserUsername}")
//    public void deleteStudent(@PathVariable("blogUserUsername") String blogUserUsername ){
//        blogUserServices.deactivateBlogUser(blogUserUsername);
//    }

    @DeleteMapping("/deactiveAccount")
    public void deleteStudent(BlogUser blogUser){
        blogUserServices.deactivateBlogUser(blogUser);
    }

    }

