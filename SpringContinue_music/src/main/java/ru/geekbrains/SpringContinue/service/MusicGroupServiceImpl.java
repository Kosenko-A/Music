package ru.geekbrains.SpringContinue.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.SpringContinue.entity.MusicGroup;
import ru.geekbrains.SpringContinue.repository.MusicGroupRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MusicGroupServiceImpl implements MusicGroupService{

    private final MusicGroupRepository musicGroupRepository;

    @Override
    public MusicGroup create(MusicGroup musicGroup) {
        return musicGroupRepository.save(musicGroup);
    }

    @Override
    public Optional<MusicGroup> read(String title) {
        return musicGroupRepository.findByTitle(title);
    }
    @Transactional
    @Override
    public Optional<MusicGroup> update(MusicGroup musicGroup) {
        musicGroupRepository.
                            findById(musicGroup.getId())
                            .ifPresent(musicGroup1 -> {
                                musicGroup1.setTitle(musicGroup.getTitle());
                                musicGroup1.setGenre(musicGroup.getGenre());
                                musicGroup1.setSoloist_sur(musicGroup.getSoloist_sur());
                                musicGroup1.setYear_found(musicGroup.getYear_found());
                                musicGroup1.setPlace(musicGroup.getPlace());
                                musicGroupRepository.save(musicGroup1);
                                    });
        return musicGroupRepository.findById(musicGroup.getId());
    }

    @Override
    public void delete(Long id) {
        musicGroupRepository.deleteById(id);
    }


}
