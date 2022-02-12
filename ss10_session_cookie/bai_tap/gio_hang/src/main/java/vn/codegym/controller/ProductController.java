package vn.codegym.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.CartDto;
import vn.codegym.dto.ProductDto;
import vn.codegym.model.Product;
import vn.codegym.service.IProductService;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @ModelAttribute("cart")
     public CartDto initCart(){
        return new CartDto();
    }


    @GetMapping("list")
    public String getAllProduct(Model model){
        model.addAttribute("product",iProductService.getAllProduct());
        return "index";
    }

    @GetMapping("detaill/{id}")
    public String finbyId(@PathVariable Integer id , Model  model){
        model.addAttribute("p",iProductService.findById(id).get());
        return "views";
    }

    @GetMapping("add/{id}")
    public  String addToCart(@PathVariable Integer id,
                             @SessionAttribute ("cart") CartDto cartDto){
        Optional<Product> productOptional = iProductService.findById(id);
        if (productOptional.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(),productDto);

            cartDto.addProductMap(productDto);
        }

        return "redirect:/cart";
    }
}
