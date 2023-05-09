package ru.kpfu.itis.semesterprojectspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.semesterprojectspring.model.entity.Training;

public interface TrainingRepository  extends JpaRepository<Training,Long> {

}
