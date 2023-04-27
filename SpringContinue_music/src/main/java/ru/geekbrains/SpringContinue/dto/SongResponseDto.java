package ru.geekbrains.SpringContinue.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SongResponseDto {

    private Long id;
    private String title;
    private Long mus_gr_id;
    private String album;
    private String genre;
    private int year;


}
