package com.app.IntelliQuiz.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    //quiz with multiple questions
    @ManyToMany
    private List<Question> questions;
}
