package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.EmployeeDto;
import vn.codegym.model.*;
import vn.codegym.service.employee.IDivisionService;
import vn.codegym.service.employee.IEducationService;
import vn.codegym.service.employee.IEmployeeService;
import vn.codegym.service.employee.IPositionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeCotroller {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IEducationService iEducationService;
    @Autowired
    private IDivisionService iDivisionService;

    @GetMapping("/list")
    public String getAllList(Model model,
                             @PageableDefault(value = 6) Pageable pageable,
                             @RequestParam(defaultValue = "") String employeeName,
                             @RequestParam(defaultValue = "") String employeeAdress,
                             @RequestParam(defaultValue = "") String position,
                             @RequestParam(defaultValue = "") String educationDegree,
                             @RequestParam(defaultValue = "") String division) {
        model.addAttribute("employee", iEmployeeService.seachEmployee(employeeName, employeeAdress, position, educationDegree, division, pageable));
        model.addAttribute("employeeName", employeeName);
        model.addAttribute("employeeAdress", employeeAdress);
        model.addAttribute("position1", position);
        model.addAttribute("educationDegree1", educationDegree);
        model.addAttribute("division1", division);
        return "employee/list";
    }

    @GetMapping("/viewAdd")
    public String viewAdd(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        return "employee/add";
    }


    @PostMapping("/addEmployee")
    public String addEmployee(@Valid @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "employee/add";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            iEmployeeService.saveEmployee(employee);
            return "redirect:/employee/list";
        }

    }


    @GetMapping("/viewUpdate/{id}")
    public String viewUpdate(@PathVariable Integer id, Model model) {
        Employee employee = iEmployeeService.findByIdEmployee(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        model.addAttribute("employeeDto", employeeDto);
        return "employee/update";
    }


    @PostMapping("/update")
    public String update(@Valid @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "employee/update";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            iEmployeeService.saveEmployee(employee);
            return "redirect:/employee/list";
        }

    }


    @ModelAttribute("position")
    public List<Position> positions() {
        return iPositionService.getAllPosition();
    }

    @ModelAttribute("eduction")
    public List<EducationDegree> eductions() {
        return iEducationService.getAllEducation();
    }

    @ModelAttribute("division")
    public List<Division> divisions() {
        return iDivisionService.getAllDivision();
    }


    @GetMapping("/views/{id}")
    public String views(@PathVariable int id, Model model) {
        model.addAttribute("e", iEmployeeService.findByIdEmployee(id));
        return "employee/views";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        iEmployeeService.deleteByEmployeeId(id);
        return "redirect:/employee/list";
    }
}
