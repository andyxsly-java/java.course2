package com.org.skypro.java.course2.ExaminerService.Service;

import com.org.skypro.java.course2.ExaminerService.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
