package ru.geekbrains.SpringContinue.dto;

import lombok.*;
import javax.validation.constraints.NotBlank;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MusicGroupRequestDto {


    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String genre;
    private String soloist_sur;
    private int year_found;
    private String place;

}
