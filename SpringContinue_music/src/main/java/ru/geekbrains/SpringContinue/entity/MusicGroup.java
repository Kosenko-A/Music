package ru.geekbrains.SpringContinue.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "music_group")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MusicGroup {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 128)
    private String title;

    @Column(name = "genre", length = 128)
    private String genre;

    @Column(name = "soloist_sur", length = 128)
    private String soloist_sur;

    @Column(name = "year")
    private int year_found;

    @Column(name = "place", length = 128)
    private String place;

}
