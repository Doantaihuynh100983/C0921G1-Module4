package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.codegym.model.Province;
import vn.codegym.service.IProvinceService;

@Controller
public class ProvinceController {
    @Autowired
    IProvinceService iProvinceService;

    @GetMapping("/provide")
    public String findAll(Model model){
        model.addAttribute("provideList",iProvinceService.findAll());
        return "province/list";
    }

    @GetMapping("/viewAddProvide")
    public String viewAdd(Model model){
        model.addAttribute("provideList",new Province());
        return "province/add";
    }
    @PostMapping("/AddProvide")
    public String addProvide(@ModelAttribute Province province){
            iProvinceService.save(province);
        return "redirect:provide";
    }

    @GetMapping("/viewUpdateProvide/{id}")
    public String viewUpdateProvide(Model model, @PathVariable Long id){
         Province province =    iProvinceService.findById(id);
        model.addAttribute("province",province);
        return "province/update";
    }


    @PostMapping("/updateProvide")
    public String updateProvide(@ModelAttribute Province province){

        iProvinceService.save(province);
        return "redirect:provide";
    }
}
