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
import vn.codegym.model.Category;
import vn.codegym.service.ICategoryService;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;
    @GetMapping({"category"})
    public String getAllBlog(Model model){
        List<Category> categories  = iCategoryService.getAllList();
        model.addAttribute("categories",categories);
        return "category/list";
    }
    @GetMapping({"viewsAddCategory"})
    public String viewsAddCategory(Model model){
        model.addAttribute("category",new Category());
        return "category/add";
    }
    @PostMapping("AddCategory")
    public String addCategory(@ModelAttribute Category Category, RedirectAttributes redirectAttributes){
        iCategoryService.save(Category);
        redirectAttributes.addFlashAttribute("msgAdd","ADD SUCCESS");
        return "redirect:/category";
    }


    @GetMapping({"viewsEditCategory/{id}"})
    public String viewsEditCategory(@PathVariable int id, Model model){
        Category Category  = iCategoryService.findById(id);
        model.addAttribute("Category",Category);
        return "category/update";
    }

    @PostMapping("editCategory")
    public String editBlog(@ModelAttribute Category Category,  RedirectAttributes redirectAttributes){
        iCategoryService.save(Category);
        redirectAttributes.addFlashAttribute("msgUpdate","UPDATE SUCCESS");
        return "redirect:/blog";
    }

    @GetMapping({"deleteCategory/{id}"})
    public String deleteBlog(@PathVariable int id,  RedirectAttributes redirectAttributes){
        iCategoryService.deleteBlog(id);
        redirectAttributes.addFlashAttribute("msgDelele","DELETE SUCCESS !!!");
        return "redirect:/blog";
    }
}
