package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Product;
import vn.codegym.service.IProductService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    IProductService iProductService;


    @GetMapping({"","product"})
    public ModelAndView findAll(){
        List<Product> productList = iProductService.findAll();
        ModelAndView modelAndView = new ModelAndView("list","product",productList);
        return modelAndView;
    }

    @GetMapping("viewAddProduct")
    public String viewAddProduct(Model model){
        model.addAttribute("product",new Product());
        return "add";
    }

    @PostMapping("addProduct")
    public String addProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
            iProductService.addProduct(product);
            redirectAttributes.addFlashAttribute("msgAdd","Add Success"+product.getId());
        return "redirect:product";
    }

    
}
