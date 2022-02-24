package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.EmployeeDto;
import vn.codegym.model.*;
import vn.codegym.repository.UserRepository;
import vn.codegym.security.MyUserDetail;
import vn.codegym.service.employee.IDivisionService;
import vn.codegym.service.employee.IEducationService;
import vn.codegym.service.employee.IEmployeeService;
import vn.codegym.service.employee.IPositionService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
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
    @Autowired
    private UserRepository userRepository;

    @ModelAttribute("user")
    public User user(HttpSession session) {
        SecurityContextImpl securityContext = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        MyUserDetail myUserDetail = (MyUserDetail) securityContext.getAuthentication().getPrincipal();
        return myUserDetail.getUser();
    }

    @GetMapping("/list")
    public String getAllList(Model model,
                             @PageableDefault(value = 6) Pageable pageable,
                             @RequestParam(defaultValue = "") String employeeName,
                             @RequestParam(defaultValue = "") String employeeAdress,
                             @RequestParam(defaultValue = "") String position,
                             @RequestParam(defaultValue = "") String educationDegree,
                             @RequestParam(defaultValue = "") String division
                             ) {

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
            employee.setFlagDeleteEmployee(1);
            iEmployeeService.saveEmployee(employee);


            User user = new User();
            user.setEmployee(employee);
            user.setUserName(employeeDto.getUsername());
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            user.setPassWord(bCryptPasswordEncoder.encode("123"));


            List<Role> roles = new ArrayList<>();
            Role role = new Role();
            if (employee.getPosition().getPositionId() == 5 || employee.getPosition().getPositionId() == 6){
                role.setRoleId(1);
            }else {
                role.setRoleId(2);
            }
            roles.add(role);
            user.setRole(roles);
            userRepository.save(user);

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
            employee.setFlagDeleteEmployee(1);
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


    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        iEmployeeService.deleteByEmployeeId(id);
        return "redirect:/employee/list";
    }
}
