package vn.codegym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.Blog;
import vn.codegym.service.IBlogService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlog(){
        List<Blog> blogList = iBlogService.getAllBlog();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Blog>> getSearchBlog(@PathVariable String name){
        List<Blog> blogList = iBlogService.findAllByName(name);

        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

}
