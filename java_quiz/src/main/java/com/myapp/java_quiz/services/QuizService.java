package com.myapp.java_quiz.services;

import com.myapp.java_quiz.model.Answer;
import com.myapp.java_quiz.model.Quiz;
import java.util.List;

public interface QuizService {
    List<Quiz> getRandom(int amount);
    List<Answer> getAnswers(int quiz_id);
}
