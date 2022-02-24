package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.ServiceDto;
import vn.codegym.model.RentType;
import vn.codegym.model.Service;
import vn.codegym.model.ServiceType;
import vn.codegym.service.service.IRentTypeService;
import vn.codegym.service.service.IServiceService;
import vn.codegym.service.service.IServiceTypeService;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private IServiceService iServiceService;
    @Autowired
    private IRentTypeService iRentTypeService;
    @Autowired
    private IServiceTypeService iServiceTypeService;

    @GetMapping("/list")
    public String getAllService(Model model,
                                @RequestParam(defaultValue = "") String serviceName ,
                                @RequestParam(defaultValue = "") String rentType ,
                                @RequestParam(defaultValue = "") String serviceType,
                                @PageableDefault(value = 5) Pageable pageable) {
            model.addAttribute("service", iServiceService.searchService(serviceName,rentType,serviceType,pageable));
            model.addAttribute("serviceName",serviceName);
            model.addAttribute("rentType",rentType);
            model.addAttribute("serviceType",serviceType);
//        model.addAttribute("service", iServiceService.getAllService());
        return "service/list";
    }

    @GetMapping("/views/{id}")
    public String findByIdService(@PathVariable Integer id, Model model) {
        model.addAttribute("service", iServiceService.findbyIdService(id));
        return "service/views";
    }

    @GetMapping("/viewAdd")
    public String viewAdd(Model model) {
        model.addAttribute("serviceDto", new ServiceDto());
        return "service/add";
    }

    @PostMapping("/addService")
    public String addService(@Valid @ModelAttribute ServiceDto serviceDto, BindingResult bindingResult) {
        new ServiceDto().validate(serviceDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "service/add";
        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            service.setFlagDeleteService(1);
            iServiceService.addNewService(service);
            return "redirect:/service/list";
        }

    }

    @GetMapping("/viewUpdate/{id}")
    public String viewUpdate(Model model, @PathVariable Integer id) {
        Service service = iServiceService.findbyIdService(id);
        ServiceDto serviceDto = new ServiceDto();
        BeanUtils.copyProperties(service, serviceDto);
        model.addAttribute("serviceDto", serviceDto);
        return "service/update";
    }

    @PostMapping("/updateService")
    public String updateService(@Valid @ModelAttribute ServiceDto serviceDto,
                                BindingResult bindingResult) {
        new ServiceDto().validate(serviceDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "service/update";
        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            service.setFlagDeleteService(1);
            iServiceService.addNewService(service);
            return "redirect:/service/list";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        iServiceService.deleteService(id);
        return "redirect:/service/list";
    }

    @ModelAttribute("rentTypeList")
    public List<RentType> getAllRentType() {
        return iRentTypeService.getAllRentType();
    }

    @ModelAttribute("serviceTypeService")
    public List<ServiceType> getAllServiceTypeService() {
        return iServiceTypeService.getAllServiceType();
    }
}
