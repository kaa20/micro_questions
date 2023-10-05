package com.myapp.java_quiz.services;

import com.myapp.java_quiz.dao.AnswerDao;
import com.myapp.java_quiz.dao.QuizDao;
import com.myapp.java_quiz.model.Answer;
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

    @Autowired
    @Setter
    private AnswerDao answerDao;

    @Override
    public List<Quiz> getRandom(int amount) {
        List<Quiz> all = quizDao.findAll();
        Collections.shuffle(all);
        return all.subList(0, amount);
    }

    @Override
    public List<Answer> getAnswers(int quiz_id) {
        Quiz quiz = quizDao.findById(quiz_id).get();
        List<Answer> all = answerDao.findAllByQuiz(quiz);
        System.out.println("from answers: " + all);
        System.out.println("from quiz: " + quiz.getAnswers());
        return all;
    }
}
