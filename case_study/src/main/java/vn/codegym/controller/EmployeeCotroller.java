package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.EmployeeDto;
import vn.codegym.model.Employee;
import vn.codegym.service.employee.IDivisionService;
import vn.codegym.service.employee.IEducationService;
import vn.codegym.service.employee.IEmployeeService;
import vn.codegym.service.employee.IPositionService;

@Controller
@RequestMapping("employee")
public class EmployeeCotroller {
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IPositionService iPositionService;
    @Autowired
    IEducationService iEducationService;
    @Autowired
    IDivisionService iDivisionService;
    @GetMapping("/list")
    public String getAllList(Model model , @PageableDefault(value = 6) Pageable pageable){
            // đang làm phân trang employee đã truyền dữ liệu tới controller đợi đẩy lên views
        model.addAttribute("employee",iEmployeeService.getAllEmployee(pageable));
        model.addAttribute("position", iPositionService.getAllPosition());
        model.addAttribute("eduction",iEducationService.getAllEducation());
        model.addAttribute("division",iDivisionService.getAllDivision());
        return "employee/list";
    }

    @GetMapping("/viewAdd")
    public String viewAdd(Model model){
        model.addAttribute("employee", new EmployeeDto());
        model.addAttribute("position", iPositionService.getAllPosition());
        model.addAttribute("eduction",iEducationService.getAllEducation());
        model.addAttribute("division",iDivisionService.getAllDivision());
        return "employee/add";
    }


    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute EmployeeDto employeeDto){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        iEmployeeService.saveEmployee(employee);
        return "redirect:/employee/list";
    }


    @GetMapping("/viewUpdate/{id}")
    public String viewUpdate(@PathVariable Integer id , Model model){
        model.addAttribute("employee",iEmployeeService.findByIdEmployee(id));
        model.addAttribute("position", iPositionService.getAllPosition());
        model.addAttribute("eduction",iEducationService.getAllEducation());
        model.addAttribute("division",iDivisionService.getAllDivision());
        return "employee/update";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute EmployeeDto employeeDto){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        iEmployeeService.saveEmployee(employee);
        return "redirect:/employee/list";
    }


}
