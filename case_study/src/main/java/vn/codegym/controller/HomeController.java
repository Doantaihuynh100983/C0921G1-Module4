package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    @GetMapping("/403")
    public String page403(){
        return "403";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
