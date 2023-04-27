package ru.geekbrains.SpringContinue.service;

import ru.geekbrains.SpringContinue.entity.MusicGroup;

import java.util.Optional;

public interface MusicGroupService {

    public MusicGroup create(MusicGroup musicGroup);

    public Optional<MusicGroup> read(String title);

    public Optional<MusicGroup> update(MusicGroup musicGroup);

    public void delete(Long id);

}
