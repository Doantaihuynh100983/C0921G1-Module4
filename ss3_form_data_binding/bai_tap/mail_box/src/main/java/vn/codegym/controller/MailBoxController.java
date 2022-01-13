package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.MailBox;
import vn.codegym.service.IMailBoxService;

import java.util.List;

@Controller
public class MailBoxController {
    @Autowired
    IMailBoxService iMailBoxService;



    @GetMapping({"","mailbox"})
    public String getAllMailBox(Model model){
        List<MailBox> mailBoxList = iMailBoxService.getAllMailBox();
        model.addAttribute("mailBoxList",mailBoxList);
        return "index";
    }


    @GetMapping("viewAdd")
    public String viewsAddMailBox(Model model){
        List<String> languages = iMailBoxService.getAllLanguges();
        model.addAttribute("languages",languages);
        List<Integer> pageSizeList = iMailBoxService.getAllPageSize();
        model.addAttribute("pageSizeList",pageSizeList);
        model.addAttribute("MailBox" , new MailBox());
        return "add";
    }

    @PostMapping("addMailBox")
    public String addNewMailBox(@ModelAttribute MailBox mailBox , RedirectAttributes redirectAttributes){
        iMailBoxService.addNewMaiBox(mailBox);
        redirectAttributes.addFlashAttribute("flagAdd"," Thêm Thành Công : "+ mailBox.getId());
        return "redirect:mailbox";
    }


    @GetMapping("vieweditMailbox/{id}")
    public String viewEditMailBox(@PathVariable int id , Model model){
        List<String> languages = iMailBoxService.getAllLanguges();
        model.addAttribute("languages",languages);
        List<Integer> pageSizeList = iMailBoxService.getAllPageSize();
        model.addAttribute("pageSizeList",pageSizeList);
        MailBox mailBox = iMailBoxService.getMailBoxById(id);
        model.addAttribute("mailBox",mailBox);
        return "edit";
    }

    @PostMapping("editMailBox")
    public  String editMailBox(@ModelAttribute MailBox mailBox, RedirectAttributes redirectAttributes){
        iMailBoxService.updateMailBox(mailBox);
        redirectAttributes.addFlashAttribute("flagEdit","Edit Thành Công : " + mailBox.getId());
        return "redirect:mailbox";
    }

}
