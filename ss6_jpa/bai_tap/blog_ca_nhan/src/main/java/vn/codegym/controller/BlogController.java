package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    @GetMapping({"deleteBlog/{id}"})
    public String deleteBlog(@PathVariable int id,  RedirectAttributes redirectAttributes){
       iBlogService.deleteBlog(id);
       redirectAttributes.addFlashAttribute("msgDelele","DELETE SUCCESS !!!");
        return "redirect:/blog";
    }


    @GetMapping({"viewsEditBlog/{id}"})
    public String viewEditBlog(@PathVariable int id,Model model){
        Blog blog  = iBlogService.findById(id);
        model.addAttribute("blog",blog);
        return "update";
    }

    @PostMapping("editBlog")
    public String editBlog(@ModelAttribute Blog blog,  RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("msgUpdate","UPDATE SUCCESS");
        return "redirect:/blog";
    }
    @GetMapping({"viewsAddBlog"})
    public String viewsAddBlog(Model model){
        model.addAttribute("blog",new Blog());
        return "add";
    }
    @PostMapping("addBlog")
    public String addBlog(@ModelAttribute Blog blog,  RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("msgAdd","ADD SUCCESS");
        return "redirect:/blog";
    }
}
