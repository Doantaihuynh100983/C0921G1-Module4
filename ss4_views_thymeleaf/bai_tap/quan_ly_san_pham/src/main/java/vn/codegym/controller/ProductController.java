package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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
    public String viewAddProduct(ModelMap modelMap){
        modelMap.addAttribute("product",new Product());
        return "add";
    }

    @PostMapping("addProduct")
    public String addProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
            iProductService.addProduct(product);
            redirectAttributes.addFlashAttribute("msgAdd","Add Success"+product.getId());
        return "redirect:/product";
    }

    @GetMapping("deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id, RedirectAttributes redirectAttributes){
        iProductService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("msgDelete","Delete Success"+ id );
        return "redirect:/product";
    }



    @GetMapping("viewEditProduct/{id}")
    public String viewEditProduct(@PathVariable int id,Model model){
        Product product =  iProductService.findById(id);
        model.addAttribute("product",product);
        return "edit";
    }
    @PostMapping("editProduct")
    public String editProduct(@ModelAttribute Product product){
        iProductService.editProduct(product);
        return "redirect:/product";
    }

    @GetMapping("viewDetail/{id}")
    public String viewDetail(@PathVariable int id,Model model){
        Product product =  iProductService.findById(id);
        model.addAttribute("product",product);
        return "detail";
    }

    @GetMapping("searchDetail")
    public String searchProduct(Model model,@RequestParam(required = false) String search2){
        List<Product> productList = iProductService.searchProduct(search2);
        model.addAttribute("product",productList);
        return "list";
    }
}
