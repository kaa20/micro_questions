package com.myapp.java_quiz.services;

import com.myapp.java_quiz.model.Quiz;
import java.util.List;

public interface QuizService {
    void addQuiz(Quiz quiz);
    List<Quiz> getRandomQuizzes(int amount);
}
