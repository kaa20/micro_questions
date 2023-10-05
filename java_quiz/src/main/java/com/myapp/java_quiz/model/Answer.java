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
public class Answer {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer answer_number;
    private String answer_text;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
