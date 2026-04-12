package com.org.skypro.java.course2.ExaminerService.Service;

import com.org.skypro.java.course2.ExaminerService.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
