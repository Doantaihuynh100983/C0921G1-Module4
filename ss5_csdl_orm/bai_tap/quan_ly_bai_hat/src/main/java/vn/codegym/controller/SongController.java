package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Song;
import vn.codegym.service.ISongService;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    ISongService iSongService;
    @GetMapping({"","song"})
    private String findAll(Model model){
        List<Song> songList = iSongService.findAll();
        model.addAttribute("songList",songList);
        return "list";
    }
    @GetMapping("viewAddSong")
    private String viewaddSong(Model model){
        model.addAttribute("songList",new Song());
        return "add";
    }
    @PostMapping("addNewSong")
    public String addSong(@ModelAttribute Song song,  RedirectAttributes redirectAttributes){

            iSongService.addSong(song);
        redirectAttributes.addFlashAttribute("msgAdd","Add success !!!");
          return "redirect:song";
    }

    @GetMapping("viewUpdateSong/{id}")
    private String viewUpdateSong(Model model, @PathVariable int id){
        Song song = iSongService.findById(id);
        model.addAttribute("songList",song);
        return "update";
    }

    @PostMapping("updateSong")
    public String updateSong(@ModelAttribute Song song ,  RedirectAttributes redirectAttributes){
        iSongService.updateSong(song);
        redirectAttributes.addFlashAttribute("msgUpdate","Update success");
        return "redirect:song";
    }
    @GetMapping("viewSong/{id}")
    private String viewSong(Model model, @PathVariable int id){
        Song song = iSongService.findById(id);
        model.addAttribute("songList",song);
        return "views";
    }
    @GetMapping("deleteSong/{id}")
    private String deleteSong(@PathVariable int id ,  RedirectAttributes redirectAttributes){
         iSongService.deleteSong(id);
        redirectAttributes.addFlashAttribute("msgDelete","Delete success" + id);
        return "redirect:song";
    }
}
