package ru.geekbrains.SpringContinue.mapper;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.SpringContinue.dto.SongRequestDto;
import ru.geekbrains.SpringContinue.dto.SongResponseDto;
import ru.geekbrains.SpringContinue.entity.Song;
import ru.geekbrains.SpringContinue.repository.MusicGroupRepository;

@RequiredArgsConstructor
@Component
public class SongMapper {

    private final MusicGroupRepository musicGroupRepository;

    public Song map(SongRequestDto dto) {
        return Song.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                //.musicGroup(musicGroupRepository.getOne(dto.getMus_gr_id()))
                .musicGroup(musicGroupRepository.findById(dto.getMus_gr_id()).get())
                .genre(dto.getGenre())
                .album(dto.getAlbum())
                .year(dto.getYear())
                .build();
    }

    public SongResponseDto map(Song entity) {
        return SongResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .mus_gr_id(entity.getMusicGroup().getId())
                .genre(entity.getGenre())
                .album(entity.getAlbum())
                .year(entity.getYear())
                .build();
    }

}
