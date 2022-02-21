package vn.codegym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.Contract;
import vn.codegym.model.ContractDetail;
import vn.codegym.service.contract.IContractService;
import vn.codegym.service.contractdetail.IAttachServiceService;
import vn.codegym.service.contractdetail.IContractDetailService;

@Controller
@RequestMapping("/contractDetail")
public class ContractDetailController {
    @Autowired
    IContractDetailService iContractDetailService;
    @Autowired
    IContractService iContractService ;
    @Autowired
    IAttachServiceService iAttachServiceService;
    @GetMapping("/list")
    public String getAllContractDetail(Model model){
        model.addAttribute("contractDetail",iContractDetailService.getAllContractDetail());
        return "contractdetail/list";
    }

    @GetMapping("/viewAddContractDetail/{id}")
    public String viewAddContractDetail(Model model , @PathVariable Integer id){

        Contract contract = iContractService.findByIdContract(id);
        ContractDetail contractDetail = new ContractDetail();
        contractDetail.setContractId(contract);
        model.addAttribute("contractDetail",contractDetail);
        model.addAttribute("attachService",iAttachServiceService.getAllAttachService());
        return "contractdetail/add";
    }
    @PostMapping("/addContractDetail")
    public String addContractDetail(@ModelAttribute ContractDetail contractDetail){
        iContractDetailService.addContractDetail(contractDetail);
        return  "redirect:/contractDetail/list";
    }
}
