package vn.codegym.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.model.KhachHang;
import vn.codegym.service.IKhachHangService;

import java.util.List;

@Controller
public class KhachHangController {

    @Autowired
    private IKhachHangService iKhachHangService;


    @GetMapping({"","khachhang"})
    public String getList(Model model){
        List<KhachHang> khachHangList = iKhachHangService.getAllKhachHang();
        model.addAttribute("khachangList",khachHangList);
        return "list";
    }

    @GetMapping("viewkhachhang/{id}")
    public String getOneKhachHang(Model model ,@PathVariable int id ){
       KhachHang khachHang = iKhachHangService.getOneKhachHang(id);
       model.addAttribute("khachHang", khachHang);
        return "viewKhachHang";
    }

    @GetMapping("deleteKhachHang/{did}")
    public String deleteKhachHang(@PathVariable int did ){
        iKhachHangService.deleteKhachHang(did);
        return "redirect:/khachhang";
    }



}
