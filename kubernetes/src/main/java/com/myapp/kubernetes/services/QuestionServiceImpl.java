package com.myapp.kubernetes.services;

import com.myapp.kubernetes.dao.QuestionDao;
import com.myapp.kubernetes.model.Question;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    @Setter
    private QuestionDao dao;

    @Setter
    @Getter
    private int version;

    @Override
    public List<Question> getRandom(int amount) {
        List<Question> all = dao.findAll();
        Collections.shuffle(all);
        return all.subList(0, amount);
    }

    @Override
    public void fillDB() {
        System.out.println("filling db with some data");
        List<Question> exercises = Arrays.asList(
                Question.builder().question("Чем отличаются ReplicationController от ReplicaSet?").answer("ReplicaSet поддерживает множественный выбор в селекторе").build(),
                Question.builder().question("Что находится на master ноде?").answer("kube-apiserver, etcd, kube-scheduler, kube-controller-manager").build()
                );
        dao.saveAll(exercises);
    }
}
