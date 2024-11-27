package es.dws.gestion_videoclip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.dws.gestion_videoclip.model.Form;
import es.dws.gestion_videoclip.service.VideoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

/**
 * VideoController
 */
@Controller
@RequestMapping("/video")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;

    @PostMapping("/add")
    public String addVideo(@Valid final Form form) {

    }

}
