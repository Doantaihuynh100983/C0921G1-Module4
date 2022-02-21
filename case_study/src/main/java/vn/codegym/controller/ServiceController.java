package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.ServiceDto;
import vn.codegym.model.RentType;
import vn.codegym.model.Service;
import vn.codegym.model.ServiceType;
import vn.codegym.service.service.IRentTypeService;
import vn.codegym.service.service.IServiceService;
import vn.codegym.service.service.IServiceTypeService;
import vn.codegym.service.service.ServiceTypeService;

import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    IServiceService iServiceService;
    @Autowired
    IRentTypeService iRentTypeService;
    @Autowired
    IServiceTypeService iServiceTypeService;

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
    @GetMapping("/viewAdd")
    public String viewAdd(Model model){
        model.addAttribute("service" , new ServiceDto());
        return "service/add";
    }
    @PostMapping("/addService")
    public String addService(@ModelAttribute ServiceDto serviceDto){
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto,service);
        iServiceService.addNewService(service);
        return "redirect:/service/list";
    }

    @GetMapping("/viewUpdate/{id}")
    public String viewUpdate(Model model , @PathVariable Integer id){
        model.addAttribute("service" ,iServiceService.findbyIdService(id));
        return "service/update";
    }
    @PostMapping("/updateService")
    public String updateService(@ModelAttribute ServiceDto serviceDto){
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto,service);
        iServiceService.addNewService(service);
        return "redirect:/service/list";
    }

    @GetMapping("/delete/{id}")
    public String delete( @PathVariable Integer id){
        iServiceService.deleteService(id);
        return "redirect:/service/list";
    }

    @ModelAttribute("rentType")
    public List<RentType> getAllRentType(){
        return iRentTypeService.getAllRentType();
    }
    @ModelAttribute("serviceTypeService")
    public List<ServiceType> getAllServiceTypeService(){
        return iServiceTypeService.getAllServiceType();
    }
}
