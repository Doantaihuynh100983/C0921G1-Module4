package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.codegym.model.Blog;
import vn.codegym.service.IBlogService;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @GetMapping({"","blog"})
    public String getAllBlog(Model model){
        List<Blog> blogList  = iBlogService.getAllList();
        model.addAttribute("blogList",blogList);
        return "list";
    }
    @GetMapping({"viewBlog/{id}"})
    public String findById(Model model , @PathVariable int id){
           Blog blog  = iBlogService.findById(id);
            model.addAttribute("blog1",blog);
            return "view";
    }
}
