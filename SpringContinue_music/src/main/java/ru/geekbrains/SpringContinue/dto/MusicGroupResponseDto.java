package ru.geekbrains.SpringContinue.dto;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MusicGroupResponseDto {

    private Long id;
    private String title;
    private String genre;
    private String soloist_sur;
    private int year_found;
    private String place;

}
