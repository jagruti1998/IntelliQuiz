package com.app.IntelliQuiz.service;

import com.app.IntelliQuiz.controller.QuizController;
import com.app.IntelliQuiz.dao.QuestionDao;
import com.app.IntelliQuiz.dao.QuizDao;
import com.app.IntelliQuiz.entity.Question;
import com.app.IntelliQuiz.entity.QuestionResponse;
import com.app.IntelliQuiz.entity.Quiz;
import com.app.IntelliQuiz.entity.SubmitResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionResponse>> getQuizQuestion(int id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionFromDB = quiz.get().getQuestions();
        List<QuestionResponse> questionForUser = new ArrayList<>();

        for (Question q : questionFromDB) {
            QuestionResponse qr = new QuestionResponse(q.getId(), q.getQuestion_title(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionForUser.add(qr);
        }

        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<SubmitResponse> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int i = 0;
        int right = 0;

        for (SubmitResponse response : responses) {
            if (response.getResponse().equals(questions.get(i).getRight_answer()))
                right++;

                i++;
            }
            return new ResponseEntity<>(right, HttpStatus.OK);
        }


    }

