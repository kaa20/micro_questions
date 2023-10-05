package com.myapp.java_quiz.dao;

import com.myapp.java_quiz.model.Answer;
import com.myapp.java_quiz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerDao extends JpaRepository<Answer,Integer> {
    List<Answer> findAllByQuiz(Quiz quiz);
}
