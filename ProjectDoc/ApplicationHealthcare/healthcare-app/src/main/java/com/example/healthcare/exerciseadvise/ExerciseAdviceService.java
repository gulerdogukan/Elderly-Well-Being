package com.example.healthcare.exerciseadvise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.healthcare.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class ExerciseAdviceService {

    @Autowired
    private ExerciseAdviceRepository exerciseAdviceRepository;

    public List<ExerciseAdvice> getAllExerciseAdvices() {
        return exerciseAdviceRepository.findAll();
    }

    public ExerciseAdvice createExerciseAdvice(ExerciseAdvice exerciseAdvice) {
        return exerciseAdviceRepository.save(exerciseAdvice);
    }

    public ExerciseAdvice updateExerciseAdvice(Long id, ExerciseAdvice exerciseAdvice) {
        ExerciseAdvice existingExerciseAdvice = exerciseAdviceRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Exercise Advice not found"));
        existingExerciseAdvice.setAdvice(exerciseAdvice.getAdvice());
        return exerciseAdviceRepository.save(existingExerciseAdvice);
    }

    public void deleteExerciseAdvice(Long id) {
        exerciseAdviceRepository.deleteById(id);
    }
}
