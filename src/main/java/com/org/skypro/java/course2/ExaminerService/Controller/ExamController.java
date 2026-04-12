package com.org.skypro.java.course2.ExaminerService.Controller;

import com.org.skypro.java.course2.ExaminerService.Question;
import com.org.skypro.java.course2.ExaminerService.Service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {

        return examinerService.getQuestions(amount);
    }
}
