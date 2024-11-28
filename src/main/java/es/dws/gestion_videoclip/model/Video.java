package es.dws.gestion_videoclip.model;

import java.time.Year;

import es.dws.gestion_videoclip.enumeration.GenreEnum;
import io.micrometer.common.lang.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Video {

    private Integer id;

    @NotBlank
    private String title;

    @NotBlank
    private String artist;

    @NotBlank
    private GenreEnum genre;

    /**
     * Tipo de dato que contiene verificacion de formato adecuada,
     * y permite acceder a metodos utiles
     */
    @Nullable
    @Past
    private Year releaseYear;

    @NotBlank
    private String videoUrl;

}
