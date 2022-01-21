package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.codegym.dto.UserDto;
import vn.codegym.entity.User;
import vn.codegym.service.IUserService;

@Controller
public class UserController {
    @Autowired
    IUserService iUserService;

    @GetMapping({"","/user"})
    public String findAll(Model model){
        model.addAttribute("user",iUserService.findAll());
        return "list";
    }
    @GetMapping("viewUser")
    public String viewUser(Model model){
        model.addAttribute("userDto",new UserDto());
        return "add";
    }
    @PostMapping("addUser")
    public  String addUser(@Validated @ModelAttribute UserDto UserDto , BindingResult bindingResult){
                 new UserDto().validate(UserDto,bindingResult);
            if (bindingResult.hasErrors()){
                return "add";
            }else {
                User user = new User();
                BeanUtils.copyProperties(UserDto , user);
                iUserService.save(user);
                return "redirect:user";
            }

    }
}
