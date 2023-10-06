package com.myapp.java_quiz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String rightAnswer;

}
