package com.myapp.kubernetes.dao;

import com.myapp.kubernetes.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionDao extends JpaRepository<Question,Integer> {
}
