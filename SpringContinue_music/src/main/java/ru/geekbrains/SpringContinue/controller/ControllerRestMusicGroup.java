package ru.geekbrains.SpringContinue.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.SpringContinue.dto.MusicGroupRequestDto;
import ru.geekbrains.SpringContinue.dto.MusicGroupResponseDto;
import ru.geekbrains.SpringContinue.entity.MusicGroup;
import ru.geekbrains.SpringContinue.mapper.MusicGroupMapper;
import ru.geekbrains.SpringContinue.service.MusicGroupService;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("api/v1/musicGroup")
@RequiredArgsConstructor
public class ControllerRestMusicGroup {

    private final MusicGroupService musicGroupService;
    private final MusicGroupMapper musicGroupMapper;

    @PostMapping
    public MusicGroupResponseDto createMusicGroup(@Valid @RequestBody MusicGroupRequestDto musicGroupRequestDto) {
        MusicGroup entity = musicGroupMapper.map(musicGroupRequestDto);
        MusicGroup musicGroup = musicGroupService.create(entity);
        return musicGroupMapper.map(musicGroup);
    }

    @GetMapping("{title}")
    public MusicGroupResponseDto readMusicGroup(@PathVariable String title) {
        MusicGroup musicGroup = musicGroupService.read(title).orElseThrow(() -> new RuntimeException("Ошибка!"));
        return musicGroupMapper.map(musicGroup);
    }

    @PostMapping("/update")
    public MusicGroupResponseDto updateMusicGroup(@Valid @RequestBody MusicGroupRequestDto musicGroupRequestDto) {
        MusicGroup entity = musicGroupMapper.map(musicGroupRequestDto);
        MusicGroup musicGroup = musicGroupService.update(entity).orElseThrow(() -> new RuntimeException("Ошибка!"));
        return musicGroupMapper.map(musicGroup);
    }

    @Transactional
    @DeleteMapping("{id}")
    public void deleteMusicGroup(@PathVariable Long id) {
        musicGroupService.delete(id);
    }
}

