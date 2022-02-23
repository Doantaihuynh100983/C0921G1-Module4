package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;


    @GetMapping("/list")
    public String getCustomer(Model model,
                              @PageableDefault(value = 6) Pageable pageable,
                              @RequestParam(defaultValue = "") String customerName,
                              @RequestParam(defaultValue = "") String customerAddress,
                              @RequestParam(defaultValue = "") String customerType) {
        model.addAttribute("customer", iCustomerService.searchCustomer(customerName, customerAddress, customerType, pageable));
        model.addAttribute("customerName", customerName);
        model.addAttribute("customerAddress", customerAddress);
        model.addAttribute("customerType1", customerType);
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
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "customer/add";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customer.setFlagDeleteCustomer(1);
            iCustomerService.saveCustomer(customer);
            return "redirect:/customer/list";
        }

    }

    @GetMapping("/viewUpdateCustomer/{id}")
    public String viewUpdateCustomer(@PathVariable Integer id, Model model) {
        Customer customer = iCustomerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerDto", customerDto);
        return "customer/update";
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(@Valid @ModelAttribute CustomerDto customerDto,
                                 BindingResult bindingResult) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "customer/update";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customer.setFlagDeleteCustomer(1);
            iCustomerService.saveCustomer(customer);
            return "redirect:/customer/list";
        }

    }

    @GetMapping("/viewsByIdCustomer/{id}")
    public String viewCustomer(@PathVariable int id, Model model) {
        model.addAttribute("c", iCustomerService.findById(id));
        return "customer/views";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam int id) {
        iCustomerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }






}
