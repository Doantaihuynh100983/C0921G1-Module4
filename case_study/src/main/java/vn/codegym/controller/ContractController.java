package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Contract;
import vn.codegym.model.Customer;
import vn.codegym.service.contract.IContractService;
import vn.codegym.service.customer.ICustomerService;
import vn.codegym.service.employee.IEmployeeService;
import vn.codegym.service.service.IServiceService;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IContractService iContractService;
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IServiceService iServiceService;
        @GetMapping("/list")
        public String getAllContract(Model model){
            model.addAttribute("contract",iContractService.getAllContract());
            return "contract/list";
        }
        @GetMapping("/viewAdd")
        public String viewAdd(Model model){
            model.addAttribute("contract",new Contract());
            model.addAttribute("customer",iCustomerService.getAllCustomer());
            model.addAttribute("employee",iEmployeeService.getAllEmployee());
            model.addAttribute("service",iServiceService.getAllService());
            return  "contract/add";
        }

        @PostMapping("/addContract")
        public String addContract(@ModelAttribute Contract contract){
                iContractService.addContract(contract);
            return "redirect:/contract/list";
        }
}
