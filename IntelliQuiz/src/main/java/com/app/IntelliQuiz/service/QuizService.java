package com.app.IntelliQuiz.service;

import com.app.IntelliQuiz.dao.QuestionDao;
import com.app.IntelliQuiz.dao.QuizDao;
import com.app.IntelliQuiz.entity.Question;
import com.app.IntelliQuiz.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions=questionDao.findRandomQuestionsByCategory(category,numQ);

        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

}
