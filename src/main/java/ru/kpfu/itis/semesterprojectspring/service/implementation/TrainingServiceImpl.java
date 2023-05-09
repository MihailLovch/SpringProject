package ru.kpfu.itis.semesterprojectspring.service.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.semesterprojectspring.model.entity.Training;
import ru.kpfu.itis.semesterprojectspring.repository.TrainingRepository;
import ru.kpfu.itis.semesterprojectspring.service.TrainingService;

import java.util.List;

@Service
@AllArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;

    @Override
    public List<Training> getAll() {
        return trainingRepository.findAll();
    }

    @Override
    public Training findById(Long id) {
        return trainingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Training with id = " + id + " not found"));
    }
}
