package com.app.IntelliQuiz.controller;

import com.app.IntelliQuiz.entity.Question;
import com.app.IntelliQuiz.entity.QuestionResponse;
import com.app.IntelliQuiz.entity.SubmitResponse;
import com.app.IntelliQuiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    //create a quiz
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return quizService.createQuiz(category,numQ,title);

    }

    //get the quiz
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionResponse>> getQuizQuestion(@PathVariable int id){
        return quizService.getQuizQuestion(id);

    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<SubmitResponse> responses){
        return quizService.calculateResult(id,responses);

    }

}
