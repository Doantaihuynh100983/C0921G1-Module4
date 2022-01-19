package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Customer;
import vn.codegym.model.Province;
import vn.codegym.service.ICustomerService;
import vn.codegym.service.IProvinceService;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    IProvinceService iProvinceService;
    @GetMapping("/customers")
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, Pageable pageable){
        Page<Customer> customers;
        if(search.isPresent()){
            customers = iCustomerService.findAllByFirstNameContaining(search.get(), pageable);
        } else {
            customers = iCustomerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("viewAddCustomer")
    public String viewAddCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("province",iProvinceService.findAll());
        return "customer/add";
    }

    @PostMapping("addCustomer")
    public String addCustomer(@ModelAttribute Customer customer){
        iCustomerService.save(customer);
        return "redirect:customers";
    }

    @GetMapping("viewUpdateCustomer/{id}")
    public String viewUpdateCustomer(Model model, @PathVariable Long id) {
            Customer customer = iCustomerService.findById(id);
            model.addAttribute("customer", customer);
            model.addAttribute("province",  iProvinceService.findAll());
               return "customer/update";
    }

    @PostMapping("updateCustomer")
    public String updateCustomer(@ModelAttribute Customer customer){
        iCustomerService.save(customer);
        return "redirect:customers";
    }

}
