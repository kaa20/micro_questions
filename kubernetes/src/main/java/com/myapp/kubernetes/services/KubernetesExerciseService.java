package com.myapp.kubernetes.services;

import com.myapp.kubernetes.model.Exercise;

import java.util.List;

public interface KubernetesExerciseService {
    List<Exercise> getRandom(int amount);
    void setVersion(int version);
    int getVersion();
    void fillDB();
}
