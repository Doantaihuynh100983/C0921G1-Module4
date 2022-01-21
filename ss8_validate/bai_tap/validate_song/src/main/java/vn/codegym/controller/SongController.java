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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.dto.SongDto;
import vn.codegym.model.Song;
import vn.codegym.service.ISongService;

@Controller
public class SongController {
    @Autowired
    ISongService iSongService;


    @GetMapping({"","/song"})
    public String findAll(Model model){

        model.addAttribute("song",iSongService.findAll());
        return "list";
    }

    @GetMapping({"viewAddSong"})
    public String viewAddSong(Model model){
        model.addAttribute("songDto",new SongDto());
        return "add";
    }

    @PostMapping("addSong")
    public String addSong(@Validated  @ModelAttribute SongDto SongDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "add";
        }else {
            Song song = new Song();
            BeanUtils.copyProperties(SongDto,song);
            iSongService.addSong(song);
            redirectAttributes.addFlashAttribute("msgAdd","Add New Success");
            return "redirect:song";
        }

    }
}
