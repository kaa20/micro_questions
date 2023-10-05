package com.myapp.java_quiz.dao;

import com.myapp.java_quiz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
