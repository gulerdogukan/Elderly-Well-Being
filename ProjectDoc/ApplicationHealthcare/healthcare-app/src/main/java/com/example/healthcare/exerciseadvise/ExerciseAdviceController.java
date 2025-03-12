package com.example.healthcare.exerciseadvise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercises")
public class ExerciseAdviceController {

    @Autowired
    private ExerciseAdviceService exerciseAdviceService;

    @GetMapping
    public List<ExerciseAdvice> getAllExerciseAdvices() {
        return exerciseAdviceService.getAllExerciseAdvices();
    }

    @PostMapping
    public ExerciseAdvice createExerciseAdvice(@RequestBody ExerciseAdvice exerciseAdvice) {
        return exerciseAdviceService.createExerciseAdvice(exerciseAdvice);
    }

    @PutMapping("/{id}")
    public ExerciseAdvice updateExerciseAdvice(@PathVariable Long id, @RequestBody ExerciseAdvice exerciseAdvice) {
        return exerciseAdviceService.updateExerciseAdvice(id, exerciseAdvice);
    }

    @DeleteMapping("/{id}")
    public void deleteExerciseAdvice(@PathVariable Long id) {
        exerciseAdviceService.deleteExerciseAdvice(id);
    }
}
