package com.myapp.java_quiz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Quiz {

    @Id
    @GeneratedValue
    private Integer id;
    private String question;

    @OneToMany(mappedBy = "quizes")
    private List<Answer> answers;

}
