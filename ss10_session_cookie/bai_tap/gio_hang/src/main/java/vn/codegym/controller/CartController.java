package vn.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import vn.codegym.dto.CartDto;

@Controller
public class CartController {
    @GetMapping("cart")
    public String showCart(@SessionAttribute(name = "cart",required = false)CartDto cartDto , Model model){
        model.addAttribute("cart",cartDto);
        return "cart";
    }
}
