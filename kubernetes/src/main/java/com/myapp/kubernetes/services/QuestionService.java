package com.myapp.kubernetes.services;

import com.myapp.kubernetes.model.Question;

import java.util.List;

public interface QuestionService {
    void addQuestion(Question question);
    List<Question> getRandom(int amount);
}
