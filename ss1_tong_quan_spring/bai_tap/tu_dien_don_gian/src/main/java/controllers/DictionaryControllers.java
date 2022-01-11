package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryControllers {
    @GetMapping({"","/dictionary"})
    public String dictionary(){
        return "index";
    }
    @PostMapping({"","/dictionary"})
    public String result(
            @RequestParam String td ,
            Model model){
        Map<String,String> stringStringMap = new HashMap<>();
        stringStringMap.put("hello","Xin Chào");
        stringStringMap.put("no","Không");
        stringStringMap.put("goodbye","Tạm Biệt");
        stringStringMap.put("Yes","Vâng");

        for (Map.Entry<String, String> entry : stringStringMap.entrySet()) {
                    if (entry.getKey().equals(td)){
                        model.addAttribute("result",entry.getValue());
                    }
        }
        return "index";
    }
}
