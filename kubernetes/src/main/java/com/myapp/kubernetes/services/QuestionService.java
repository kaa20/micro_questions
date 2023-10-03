package com.myapp.kubernetes.services;

import com.myapp.kubernetes.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getRandom(int amount);
    void setVersion(int version);
    int getVersion();
    void fillDB();
}
