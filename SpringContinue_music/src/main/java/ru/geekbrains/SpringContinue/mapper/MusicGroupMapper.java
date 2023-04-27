package ru.geekbrains.SpringContinue.mapper;

import org.springframework.stereotype.Component;
import ru.geekbrains.SpringContinue.dto.MusicGroupRequestDto;
import ru.geekbrains.SpringContinue.dto.MusicGroupResponseDto;
import ru.geekbrains.SpringContinue.entity.MusicGroup;

@Component
public class MusicGroupMapper {

    public MusicGroup map(MusicGroupRequestDto dto) {
        return MusicGroup.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .genre(dto.getGenre())
                .soloist_sur(dto.getSoloist_sur())
                .year_found(dto.getYear_found())
                .place(dto.getPlace())
                .build();


    }

    public MusicGroupResponseDto map(MusicGroup entity) {
        return MusicGroupResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .genre(entity.getGenre())
                .soloist_sur(entity.getSoloist_sur())
                .year_found(entity.getYear_found())
                .place(entity.getPlace())
                .build();
    }
}
