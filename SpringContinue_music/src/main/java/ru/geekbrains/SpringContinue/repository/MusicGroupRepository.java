package ru.geekbrains.SpringContinue.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.SpringContinue.entity.MusicGroup;

import java.util.Optional;

@Repository
public interface MusicGroupRepository extends JpaRepository<MusicGroup, Long> {

    Optional<MusicGroup> findByTitle(String title);

    Optional<MusicGroup> findById(Long musGrId);
}