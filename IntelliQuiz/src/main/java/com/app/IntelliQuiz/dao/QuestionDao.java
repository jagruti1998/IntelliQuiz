package com.app.IntelliQuiz.dao;


import com.app.IntelliQuiz.IntelliQuizApplication;
import com.app.IntelliQuiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question>findByCategory(String category);

    @Query("SELECT q FROM Question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numQ")
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
