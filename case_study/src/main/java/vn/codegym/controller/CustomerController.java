package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.CustomerDto;
import vn.codegym.model.Customer;
import vn.codegym.model.CustomerType;
import vn.codegym.service.customer.ICustomerService;
import vn.codegym.service.customer.ICustomerTypeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller

public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    ICustomerTypeService iCustomerTypeService;


    @GetMapping({"/customer"})
    public String getAllCustomer(Model model,
                                 @PageableDefault(value = 6) Pageable pageable,
                                 @RequestParam(defaultValue = "") String customerName,
                                 @RequestParam(defaultValue = "") String customerAddress,
                                 @RequestParam(defaultValue = "") String customerType) {
        model.addAttribute("customer", iCustomerService.searchCustomer(customerName, customerAddress, customerType, pageable));
        return "customer/list";
    }

    @ModelAttribute("customerType")
    public List<CustomerType> customerType() {
        return iCustomerTypeService.getAllCustomerType();
    }

    @GetMapping("/viewAdd")
    public String viewAddCustomer(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/add";
    }

    @PostMapping("/viewNewAdd")
    public String addCustomer(@Valid @ModelAttribute CustomerDto customerDto,
                              BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "customer/add";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.saveCustomer(customer);
            return "redirect:/customer";
        }

    }

    @GetMapping("/viewUpdateCustomer/{id}")
    public String viewUpdateCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "customer/update";
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute Customer customer) {
        iCustomerService.saveCustomer(customer);
        return "redirect:/customer";
    }

    @GetMapping("/viewsByIdCustomer/{id}")
    public String viewCustomer(@PathVariable int id, Model model) {
        model.addAttribute("c", iCustomerService.findById(id));
        return "customer/views";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id) {
        iCustomerService.deleteCustomer(id);
        return "redirect:/customer";
    }


}
