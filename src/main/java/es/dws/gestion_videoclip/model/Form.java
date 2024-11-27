package es.dws.gestion_videoclip.model;

import org.hibernate.validator.constraints.Length;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Form
 */
@Data
@AllArgsConstructor
@Builder
public class Form {

    @NotBlank
    private String title;

    @NotBlank
    private String artist;

    @NotBlank
    private String genre;

    @Nullable
    @Length(min = 4, max = 4)
    @Min(1500)
    private Integer releaseYear;

    @NotBlank
    private String videoUrl;

}
