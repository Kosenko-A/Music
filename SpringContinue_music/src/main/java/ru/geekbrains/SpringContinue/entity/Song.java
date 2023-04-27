package ru.geekbrains.SpringContinue.entity;

import lombok.*;
import javax.persistence.*;

@Builder
@Entity
@Table(name = "song")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Song {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 128)
    private String title;

    @ManyToOne
    @JoinColumn(name = "mus_gr_id", referencedColumnName = "id", nullable = false)
    private MusicGroup musicGroup;

    @Column(name = "album", length = 128)
    private String album;

    @Column(name = "genre", length = 128)
    private String genre;

    @Column(name = "year")
    private int year;

}