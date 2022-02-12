package vn.codegym.ung_dung_muon_sach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.ung_dung_muon_sach.model.Book;
import vn.codegym.ung_dung_muon_sach.model.CodeBook;
import vn.codegym.ung_dung_muon_sach.service.IBookService;
import vn.codegym.ung_dung_muon_sach.service.ICodeBookService;

@Controller
public class BookController {
    @Autowired
    IBookService bookService;

    @Autowired
    ICodeBookService codeBookService;

    @GetMapping("/list")
    public ModelAndView list(@PageableDefault(value = 3)Pageable pageable){
        return new ModelAndView("list","book",bookService.findAll(pageable));
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model){
        model.addAttribute("book",bookService.findById(id));
        return "/view";
    }

    @PostMapping("/rent")
    public String rent(@ModelAttribute Book book, Model model) throws Exception {
        if (book.getQuantity()>0){
            model.addAttribute("code","book rental code is: " +  codeBookService.saveCodeBook(book));
            book.setQuantity(book.getQuantity()-1);
            bookService.save(book);
            return "/view";
        }else {
            throw new Exception();
        }
    }

    @GetMapping("/giveBack")
    public String giveBack(Long codeBook, RedirectAttributes redirectAttributes){
        CodeBook codeBook1=codeBookService.findByCodeBook(codeBook);
        if (codeBook1 !=null){
            codeBookService.delete(codeBook);
            bookService.giveBack(codeBook1.getBook().getId());
            redirectAttributes.addFlashAttribute("msg","returned the book");
        }else {
            redirectAttributes.addFlashAttribute("smg","not found");
        }
        return "redirect:/list";
    }

    @ExceptionHandler(value = Exception.class)
    public String error(){
        return "/error";
    }
}
