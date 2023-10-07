package com.myapp.kubernetes.utils;

import com.myapp.kubernetes.model.Question;
import com.myapp.kubernetes.services.QuestionService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionInitUtils {

    @Autowired
    private QuestionService questionService;

    @PostConstruct
    public void init() {
        Question q1 = Question.builder()
                .question("Чем отличаются ReplicationController от ReplicaSet?")
                .answer("ReplicaSet поддерживает множественный выбор в селекторе")
                .build();

        Question q2 = Question.builder()
                .question("Что находится на master ноде?")
                .answer("kube-apiserver, etcd, kube-scheduler, kube-controller-manager")
                .build();

        questionService.addQuestion(q1);
        questionService.addQuestion(q2);
    }
}
