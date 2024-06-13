package com.app.IntelliQuiz.controller;


import com.app.IntelliQuiz.dao.QuestionDao;
import com.app.IntelliQuiz.entity.Question;
import com.app.IntelliQuiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    QuestionDao questionDao;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question> >getAllQuestions() {
        return questionService.getAllQuestions();
    }


    @GetMapping("category/{category}")
    public ResponseEntity <List<Question>> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);

    }

    //adding question

    @PostMapping("add")
    public ResponseEntity <String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id) {
        boolean isDeleted = questionService.deleteQuestion(id);
        if (isDeleted) {
            return ResponseEntity.ok("Question deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found");
        }
    }
}
