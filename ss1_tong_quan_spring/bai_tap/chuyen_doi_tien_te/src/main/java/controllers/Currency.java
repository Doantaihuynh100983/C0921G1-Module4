package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Currency {
        @GetMapping({"","/currency"})
        public String currencyConversion(){
            return "index";
        }



        @PostMapping({"","/currency"})
        public String result(
                @RequestParam double usd ,
                Model model){
            double result = usd * 24000;
            model.addAttribute("result",result);
            return "index";
        }
}
