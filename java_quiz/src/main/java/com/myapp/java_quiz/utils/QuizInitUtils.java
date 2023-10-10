package com.myapp.java_quiz.utils;

import com.myapp.java_quiz.model.Quiz;
import com.myapp.java_quiz.services.QuizService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuizInitUtils {

    @Autowired
    private QuizService quizService;

    @PostConstruct
    public void init() {
        Quiz quiz1 = Quiz.builder().question("Что такое SOLID?")
                .answerA("Software Library for Interference Detection")
                .answerB("Society of Leaders in Development")
                .answerC("Salt Spring Organization for Life Improvement and Development")
                .answerD("Single responsibility, Open–closed, Liskov substitution, Interface segregation и Dependency inversion")
                .answer("Single responsibility, Open–closed, Liskov substitution, Interface segregation и Dependency inversion")
                .build();

        Quiz quiz2 = Quiz.builder().question("Что такое Dependency Injection?")
                .answerA("Подключение зависимостей dependency в maven проект")
                .answerB("Набор паттернов и принципов разработки программного обеспечения, которые позволяют писать слабо связанный код")
                .answerC("Принцип согласно которому модули высокого уровня не должны зависеть от модулей низкого уровня")
                .answerD("Шаблон, в котором управление потоком приложения передается внешнему фреймворку или контейнеру")
                .answer("Набор паттернов и принципов разработки программного обеспечения, которые позволяют писать слабо связанный код")
                .build();

        quizService.addQuiz(quiz1);
        quizService.addQuiz(quiz2);
    }

}
