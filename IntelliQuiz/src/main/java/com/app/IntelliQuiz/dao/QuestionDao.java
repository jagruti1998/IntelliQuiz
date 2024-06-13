package com.app.IntelliQuiz.dao;


import com.app.IntelliQuiz.IntelliQuizApplication;
import com.app.IntelliQuiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
}
