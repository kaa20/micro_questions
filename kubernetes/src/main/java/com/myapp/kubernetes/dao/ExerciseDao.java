package com.myapp.kubernetes.dao;

import com.myapp.kubernetes.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseDao extends JpaRepository<Exercise,Integer> {
}
