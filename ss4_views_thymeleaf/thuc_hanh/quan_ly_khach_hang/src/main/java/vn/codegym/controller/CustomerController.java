package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Customer;
import vn.codegym.service.ICustomerService;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;

    @GetMapping({"", "/customer"})
    public String findAll(Model model) {
        List<Customer> customerList = iCustomerService.findAll();
        model.addAttribute("customerList",customerList);
        return "list";
    }

    @GetMapping("/customerById/{id}")
    public String findById(@PathVariable int id , Model model){
        Customer customer = iCustomerService.findById(id);
        model.addAttribute("customer",customer);
        return "deltail";
    }

    @GetMapping("addCustomer")
        public String addViewCustomer(Model model){

            model.addAttribute("customer",new Customer());
            return "creat";
        }
    @PostMapping("addNewCustomer")
    public String addNewCustomer(@ModelAttribute Customer customer , RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("msgAdd","Add success !!!");
            iCustomerService.addCustomer(customer);
        return "redirect:/customer";
    }
    @GetMapping("deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable int id,RedirectAttributes redirectAttributes){

        iCustomerService.deleteCustomer(id);
        redirectAttributes.addFlashAttribute("msgDelete","Delete success");
        return "redirect:/customer";
    }


    @GetMapping("viewEidtCustomer/{id}")
    public String viewEditCustomer(Model model, @PathVariable int id){
        Customer customer = iCustomerService.findById(id);
        model.addAttribute("customer",customer);
        return "edit";
    }
    @PostMapping("editCustomer")
    public String editCustomer(@ModelAttribute Customer customer,RedirectAttributes redirectAttributes){
            iCustomerService.editCustomer(customer.getId(),customer);
            redirectAttributes.addFlashAttribute("msgEdit","Update success" + customer.getName());
        return "redirect:/customer";
    }

}
