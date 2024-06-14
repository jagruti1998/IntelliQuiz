package com.app.IntelliQuiz.service;


import com.app.IntelliQuiz.controller.QuestionController;
import com.app.IntelliQuiz.dao.QuestionDao;
import com.app.IntelliQuiz.entity.Question;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;




    public ResponseEntity <List<Question>> getAllQuestions() {
        try {

            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity <List<Question>> getQuestionsByCategory(String category) {
        try {


            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();

        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity <String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    public boolean deleteQuestion(int id) {
        if (questionDao.existsById(id)) {
            questionDao.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

