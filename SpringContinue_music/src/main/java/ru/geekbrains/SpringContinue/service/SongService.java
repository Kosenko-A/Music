package ru.geekbrains.SpringContinue.service;


import ru.geekbrains.SpringContinue.entity.Song;

import java.util.Optional;

public interface SongService {

    public Song create(Song song);

    public Optional<Song> read(String title);

    public Optional<Song> update(Song song);

    public void delete(Long id);
}
