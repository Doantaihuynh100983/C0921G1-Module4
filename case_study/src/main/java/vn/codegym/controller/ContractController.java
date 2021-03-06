package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.ContractDto;
import vn.codegym.model.Contract;
import vn.codegym.model.Customer;
import vn.codegym.model.Employee;
import vn.codegym.model.Service;
import vn.codegym.service.contract.IContractService;
import vn.codegym.service.customer.ICustomerService;
import vn.codegym.service.employee.IEmployeeService;
import vn.codegym.service.service.IServiceService;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IServiceService iServiceService;

    @GetMapping("/list")
    public String getAllContract(Model model) {
        model.addAttribute("contract", iContractService.getAllContract());
        return "contract/list";
    }

    @GetMapping("/viewAdd")
    public String viewAdd(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        return "contract/add";
    }

    @PostMapping("/addContract")
    public String addContract(@Valid @ModelAttribute ContractDto contractDto,
                              BindingResult bindingResult,
                              Model model) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "contract/add";
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            iContractService.addContract(contract);
            return "redirect:/contract/list";
        }

    }



    @ModelAttribute("customer")
    public List<Customer> customers(){
        return iCustomerService.getAllCustomer();
    }


    @ModelAttribute("employee")
    public List<Employee> employees(){
        return iEmployeeService.getAllEmployee();
    }
    @ModelAttribute("service")
    public List<Service> services(){
        return iServiceService.getAllService();
    }

}
