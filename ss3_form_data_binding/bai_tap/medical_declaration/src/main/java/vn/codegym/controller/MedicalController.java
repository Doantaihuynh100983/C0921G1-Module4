package vn.codegym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Medical;
import vn.codegym.service.IMedicalService;

import java.util.List;

@Controller
public class MedicalController {
    @Autowired
    IMedicalService iMedicalService;

    @GetMapping({"","medical"})
    public ModelAndView viewsAddMedical(){
        ModelAndView modelAndView = new ModelAndView("index","medical",new Medical());
        List<String> listQuocTich = iMedicalService.quocTich();
        modelAndView.addObject("listQuocTich",listQuocTich);
        List<String> thongTinDiLai = iMedicalService.thongTinDiLai();
        modelAndView.addObject("thongTinDiLai",thongTinDiLai);
        List<String> tinhThanh = iMedicalService.tinhThanh();
        modelAndView.addObject("tinhThanh",tinhThanh);
        List<String> quanHuyen = iMedicalService.quanHuyen();
        modelAndView.addObject("quanHuyen",quanHuyen);
        List<String> phuongXa = iMedicalService.phuongXa();
        modelAndView.addObject("phuongXa",phuongXa);
        List<String> trieuChung = iMedicalService.trieuCHung();
        modelAndView.addObject("trieuChung",trieuChung);
        return modelAndView;
    }




    @PostMapping("/addMedical")
    public String addMedical(@ModelAttribute Medical medical ,Model model){
        model.addAttribute("medical",medical);
        List<String> listQuocTich = iMedicalService.quocTich();
        model.addAttribute("listQuocTich",listQuocTich);
        List<String> thongTinDiLai = iMedicalService.thongTinDiLai();
        model.addAttribute("thongTinDiLai",thongTinDiLai);
        List<String> tinhThanh = iMedicalService.tinhThanh();
        model.addAttribute("tinhThanh",tinhThanh);
        List<String> quanHuyen = iMedicalService.quanHuyen();
        model.addAttribute("quanHuyen",quanHuyen);
        List<String> phuongXa = iMedicalService.phuongXa();
        model.addAttribute("phuongXa",phuongXa);
        List<String> trieuChung = iMedicalService.trieuCHung();
        model.addAttribute("trieuChung",trieuChung);
        model.addAttribute("flagThongBao","LƯU THÔNG TIN THÀNH CÔNG !!");
        return "index";
    }
}
