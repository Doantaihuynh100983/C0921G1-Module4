package vn.codegym.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.codegym.model.Customer;
import vn.codegym.service.ICustomerService;

import java.util.List;

@Controller
public class CustomerControllers {
    @Autowired
    ICustomerService iCustomerService;

    @GetMapping({"", "/customer"})
    public String finAll(Model model) {
        List<Customer> customerList = iCustomerService.findAll();
        model.addAttribute("customerList", customerList);
        return "list";
    }


    @GetMapping("viewAddCustomer")
    public String viewAddCustomer(Model model) {
        model.addAttribute("customer",new Customer());
        return "add";
    }
    @PostMapping("addCustomer")
    public String addCustomer(@ModelAttribute Customer customer){
        iCustomerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable int id){
        iCustomerService.delete(id);
        return "redirect:/customer";
    }
    @GetMapping("views/{id}")
    public String viewsCustomer(@PathVariable int id, Model model){
    Customer customer=  iCustomerService.findById(id);
    model.addAttribute("customer",customer);
        return "views";
    }


}
