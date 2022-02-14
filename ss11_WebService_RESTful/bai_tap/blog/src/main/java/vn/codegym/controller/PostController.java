package vn.codegym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.model.Posts;
import vn.codegym.service.IPostService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    IPostService iPostService;

    @GetMapping
    public ResponseEntity<List<Posts>> getAllPosse(){
        List<Posts> postsList = iPostService.getAllPost();
        if (postsList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(postsList,HttpStatus.OK);

    }


    @GetMapping("/category/{id}")
    public  ResponseEntity<List<Posts>> getByCategory(@PathVariable Integer id){
        List<Posts> postsList = iPostService.getFindByIdCategory(id);
        if (postsList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(postsList,HttpStatus.OK);

    }


    @GetMapping("/byIdPost/{id}")
    public ResponseEntity<Optional<Posts>> getById(@PathVariable Integer id){
        Optional<Posts> optionalPosts = iPostService.getByIdPost(id);
        if (optionalPosts.isPresent()){
            return new ResponseEntity<>(optionalPosts,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
