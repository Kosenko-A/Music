package ru.geekbrains.SpringContinue.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.SpringContinue.entity.Song;
import ru.geekbrains.SpringContinue.repository.MusicGroupRepository;
import ru.geekbrains.SpringContinue.repository.SongRepository;

import java.util.Optional;

@Service
public class SongServiceImpl implements SongService{

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Song create(Song song) {
        return songRepository.save(song);
    }

    @Override
    public Optional<Song> read(String title) {
        return songRepository.findByTitle(title);
    }

    @Override
    public Optional<Song> update(Song song) {
        songRepository.
                findById(song.getId())
                .ifPresent(song1 -> {
                    song1.setTitle(song.getTitle());
                    song1.setGenre(song.getGenre());
                    song1.setMusicGroup(song.getMusicGroup());
                    song1.setAlbum(song.getAlbum());
                    song1.setYear(song.getYear());
                    songRepository.save(song1);
                });
        return songRepository.findById(song.getId());

    }

    @Override
    public void delete(Long id) {
        songRepository.deleteById(id);
    }
}
