package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.codegym.model.Blog;
import vn.codegym.service.IBlogService;

@Controller
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @GetMapping({"","/blog"})
    public String getAllBlog(Model model){
        model.addAttribute("blog",iBlogService.getAllBlog());
        return "list";
    }
    @GetMapping("/add")
    public String addBlog(Model model){
        model.addAttribute("blog",new Blog());
        return "add";
    }
    @PostMapping("/addNewBlog")
    public String addNewBlog(@ModelAttribute Blog blog){
        iBlogService.addBlog(blog);
        return "redirect:blog";
    }
}
