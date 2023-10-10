package com.myapp.kubernetes.controllers;

import com.myapp.kubernetes.model.Question;
import com.myapp.kubernetes.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class QuestionsController {
    private final QuestionService service;

    @GetMapping("/questions")
    public List<Question> getQuestions(@RequestParam(value = "amount", defaultValue = "1") Integer amount) {
        return service.getRandom(amount);
    }

}
