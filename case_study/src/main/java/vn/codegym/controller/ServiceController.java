package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.service.service.IServiceService;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    IServiceService iServiceService;

    @GetMapping("/list")
    public String getAllService(Model model, Pageable pageable) {
        model.addAttribute("service", iServiceService.getAllService(pageable));
        return "service/list";
    }

    @GetMapping("/views/{id}")
    public String findByIdService(@PathVariable Integer id, Model model) {
        model.addAttribute("service", iServiceService.findbyIdService(id));
        return "service/views";
    }
}
