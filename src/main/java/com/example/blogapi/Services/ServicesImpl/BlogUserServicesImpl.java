package com.example.blogapi.Services.ServicesImpl;

import com.example.blogapi.Dto.UserDto;
import com.example.blogapi.Models.BlogPost;
import com.example.blogapi.Models.BlogUser;
import com.example.blogapi.Models.Comments;
import com.example.blogapi.Models.FavouritePost;
import com.example.blogapi.Repositories.BlogPostRepository;
import com.example.blogapi.Repositories.BlogUserRepository;
import com.example.blogapi.Repositories.CommentRepository;
import com.example.blogapi.Repositories.FavouritePostRepository;
import com.example.blogapi.Services.BlogUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BlogUserServicesImpl implements BlogUserService {

    @Autowired
    private final BlogUserRepository blogUserRepository;
    private final BlogPostRepository blogPostRepository;
    private final FavouritePostRepository favouritePostRepository;
    private final CommentRepository commentRepository;

    @Override
    public String addNewUser(BlogUser blogUser) {
        Optional<BlogUser> userByUsername = blogUserRepository.findBlogUserByUsername(blogUser.getUsername());
        if (userByUsername.isPresent()){
            throw new IllegalStateException("This username has already been taken");
        }
        blogUserRepository.save(blogUser);
        return "Welcome " + blogUser.getUsername() + ", you have successfully registered";
    }

    @Override
    public Boolean login(UserDto userDto) {
        Optional<BlogUser> userByUsername = blogUserRepository.findBlogUserByUsername(userDto.getUsername());
        if (userByUsername.isEmpty()){
            throw new IllegalStateException("This user is not in our database, please register");
        }
        else    {
            return Boolean.TRUE;
        }
    }

    @Override
    public BlogPost makeNewBlogPost(BlogPost blogPost) {
        blogPost.setCreatedDate(Instant.now());
       return blogPostRepository.save(blogPost);

    }

    @Override
    public String addToFavouritesPost(FavouritePost favouritePost) {
        favouritePostRepository.save(favouritePost);
        return "Post added to favourite";
    }

    @Override
    public List<BlogUser> getAllBlogUsers (){
        return blogUserRepository.findAll();
    }

    @Override
    public String getFavouriteBlogPost() {
        favouritePostRepository.findAll();
return "You have all your favouritePost in one place!";
    }

    @Override
    public Comments makeNewcomment(Comments comments) {
      commentRepository.save(comments);
        return comments;
    }

    @Override
    public List<BlogPost> getAllBlogPost() {
        return blogPostRepository.findAll();
    }

    @Override
    @Scheduled(initialDelay = 10)
    public String deactivateBlogUser(BlogUser blogUser) {
        boolean exists = blogUserRepository.existsById(blogUser.getId());
        if (!exists){
            throw new IllegalStateException("blogUser with id: " + blogUser.getId() + " does not exist");
        }
       blogUserRepository.delete(blogUser);
        return "Sad to let you go, deactivation would happen in 1000ms";
    }

//    @Override
//    @Scheduled(initialDelay = 10)
//    public void deactivateBlogUser(String blogUserUsername) {
//        Optional<BlogUser> blogUserExists = blogUserRepository.findBlogUserByUsername(blogUserUsername);
//        if (!blogUserExists.isPresent()){
//            throw new IllegalStateException("blogUser with this username: " +blogUserUsername + " does not exist!");
//        }
//        blogUserRepository.
//        blogUserRepository.delete(blogUserExists);
//        studentRepository.deleteById(studentId);
//    }


    }



