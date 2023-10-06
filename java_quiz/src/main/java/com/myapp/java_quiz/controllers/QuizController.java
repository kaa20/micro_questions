package com.myapp.java_quiz.controllers;

import com.myapp.java_quiz.model.Quiz;
import com.myapp.java_quiz.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService service;

    @GetMapping("/quizzes")
    public List<Quiz> getQuiz(@RequestParam(value = "amount", defaultValue = "1") Integer amount) {
        return service.getRandomQuizzes(amount);
    }

}
