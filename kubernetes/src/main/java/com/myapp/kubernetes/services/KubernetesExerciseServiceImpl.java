package com.myapp.kubernetes.services;

import com.myapp.kubernetes.dao.ExerciseDao;
import com.myapp.kubernetes.model.Exercise;
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
public class KubernetesExerciseServiceImpl implements KubernetesExerciseService {

    @Autowired
    @Setter
    private ExerciseDao dao;

    @Setter
    @Getter
    private int version;

    @Override
    public List<Exercise> getRandom(int amount) {
        List<Exercise> all = dao.findAll();
        Collections.shuffle(all);
        return all.subList(0, amount);
    }

    @Override
    public void fillDB() {
        System.out.println("filling db with some data");
        List<Exercise> exercises = Arrays.asList(
                Exercise.builder().question("Чем отличаются ReplicationController от ReplicaSet?").answer("ReplicaSet поддерживает множественный выбор в селекторе").build(),
                Exercise.builder().question("Что находится на master ноде?").answer("kube-apiserver, etcd, kube-scheduler, kube-controller-manager").build()
                );
        dao.saveAll(exercises);
    }
}
