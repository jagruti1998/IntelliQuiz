package com.app.IntelliQuiz.entity;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SubmitResponse {

    private int id;
    private String response;
}
