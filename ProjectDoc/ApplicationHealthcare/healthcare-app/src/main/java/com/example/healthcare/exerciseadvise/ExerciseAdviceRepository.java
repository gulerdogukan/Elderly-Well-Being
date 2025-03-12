package com.example.healthcare.exerciseadvise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseAdviceRepository extends JpaRepository<ExerciseAdvice, Long> {
}
