package ru.geekbrains.SpringContinue.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.SpringContinue.dto.SongRequestDto;
import ru.geekbrains.SpringContinue.dto.SongResponseDto;
import ru.geekbrains.SpringContinue.entity.MusicGroup;
import ru.geekbrains.SpringContinue.entity.Song;
import ru.geekbrains.SpringContinue.mapper.MusicGroupMapper;
import ru.geekbrains.SpringContinue.mapper.SongMapper;
import ru.geekbrains.SpringContinue.service.SongService;
import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("api/v1/song")
@RequiredArgsConstructor
public class ControllerRestSong {

    private final SongService songService;
    private final SongMapper songMapper;

    @PostMapping
    public SongResponseDto createSong(@Valid @RequestBody SongRequestDto songRequestDto) {
        Song entity = songMapper.map(songRequestDto);
        Song song = songService.create(entity);
        return songMapper.map(song);
    }

    @GetMapping("{title}")
    public SongResponseDto readSong(@PathVariable String title) {
        Song song = songService.read(title).orElseThrow(() -> new RuntimeException("Ошибка!"));
        return songMapper.map(song);
    }

    @PostMapping("/update")
    public SongResponseDto updateSong(@Valid @RequestBody SongRequestDto songRequestDto) {
        Song entity = songMapper.map(songRequestDto);
        Song song = songService.update(entity).orElseThrow(() -> new RuntimeException("Ошибка!"));
        return songMapper.map(song);
    }

    @Transactional
    @DeleteMapping("{id}")
    public void deleteSong(@PathVariable Long id) {
        songService.delete(id);
    }
}
