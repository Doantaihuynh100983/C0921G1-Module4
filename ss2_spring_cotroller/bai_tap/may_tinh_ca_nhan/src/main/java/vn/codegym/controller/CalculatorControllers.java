package vn.codegym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.service.ICalculator;

@Controller
public class CalculatorControllers {

    @Autowired
    ICalculator iCalculator;

        @GetMapping({"","/maytinh"})
        public String mayTinh(){
            return "index";
        }


        @PostMapping({"","/maytinh"})
    public String result(
            @RequestParam double number1,
            @RequestParam double number2,
            @RequestParam String calculation,
            Model model){
            if ( (number1 == 0 || number2 == 0 ) &&  calculation.equals("Division")){
                model.addAttribute("message","Không được chia 0");
            }else {
                double reusult = iCalculator.calculaTion(number1,number2,calculation);
                model.addAttribute("result",reusult);
            }


            return "index";
        }
}
