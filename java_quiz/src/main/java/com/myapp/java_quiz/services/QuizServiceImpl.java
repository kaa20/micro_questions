package com.myapp.java_quiz.services;

import com.myapp.java_quiz.dao.QuizDao;
import com.myapp.java_quiz.model.Quiz;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {

    @Autowired
    @Setter
    private QuizDao quizDao;

    @Override
    public List<Quiz> getRandomQuizzes(int amount) {
        List<Quiz> all = quizDao.findAll();
        Collections.shuffle(all);
        return all.subList(0, amount);
    }

    @Override
    public void addQuiz(Quiz quiz) {
        quizDao.save(quiz);
    }
}
