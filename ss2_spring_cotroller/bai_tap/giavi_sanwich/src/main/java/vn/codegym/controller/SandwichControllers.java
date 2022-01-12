package vn.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichControllers {
    @GetMapping({"","/index"})
    public String sandWich(){
        return "index";
    }



    @PostMapping("/sandwich")
    public String getSandWich(@RequestParam(required = false,defaultValue = "Chưa chọn gì cả") String[] vehicle , Model model){
        model.addAttribute("sanwich",vehicle);
        return "index";
    }
}
