package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.codegym.model.Mailbox;
import vn.codegym.service.IMailboxService;

import java.util.List;

@Controller
public class MailboxController {
    @Autowired
    IMailboxService iMailboxService;

    @GetMapping({"","/mailbox"})
    public String mailboxList(Model model){
        List<Mailbox> mailboxList = iMailboxService.mailboxList();
        model.addAttribute("mailboxList",mailboxList);
        return "index";
    }
}
