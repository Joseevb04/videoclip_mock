package es.dws.gestion_videoclip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.dws.gestion_videoclip.enumeration.GenreEnum;
import es.dws.gestion_videoclip.service.VideoService;
import lombok.RequiredArgsConstructor;

/**
 * HomeController
 */
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final VideoService videoService;

    @GetMapping({ "/", "/home", "/index" })
    public String showHome(final Model model) {

        model.addAttribute("videos", videoService.getAllVideos());
        model.addAttribute("genres", GenreEnum.values());
        return "indexView";
    }

    @GetMapping("/add")
    public String showAddForm(final Model model) {
        model.addAttribute("genres", GenreEnum.values());
        return "addVideoView";
    }

}
