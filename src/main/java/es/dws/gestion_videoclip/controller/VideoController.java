package es.dws.gestion_videoclip.controller;

import java.time.Year;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.dws.gestion_videoclip.model.Form;
import es.dws.gestion_videoclip.model.Video;
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
        videoService.addVideo(Video.builder()
                .title(form.getTitle())
                .artist(form.getArtist())
                .genre(form.getGenre())
                .videoUrl(form.getVideoUrl())
                .releaseYear(form.getReleaseYear() != null ? Year.of(form.getReleaseYear()) : null)
                .build());

        return "redirect:/?success=1";
    }

    // Hace falta agregar la linea `spring.mvc.hiddenmethod.filter.enabled=true` en
    // el application.properties
    @DeleteMapping("/delete/{id}")
    public String deleteVideo(@PathVariable(name = "id", required = true) final Integer id) {
        return videoService.deleteVideoById(id)
                ? "redirect:/?success=2"
                : "redirect:/?error=2";
    }

}
