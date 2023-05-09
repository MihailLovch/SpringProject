package ru.kpfu.itis.semesterprojectspring.service;

import ru.kpfu.itis.semesterprojectspring.model.entity.Training;

import java.util.List;

public interface TrainingService {
    List<Training> getAll();
    Training findById(Long id);
}
