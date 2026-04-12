package com.org.skypro.java.course2.ExaminerService.Service;

import com.org.skypro.java.course2.ExaminerService.Question;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;
    private final Random random = new Random();

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        Collection<Question> allQuestions = questionService.getAll();

        if (amount > allQuestions.size()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Запрошено больше вопросов, чем доступно"
            );
        }

        List<Question> questionsList = new ArrayList<>(allQuestions);
        Set<Question> result = new HashSet<>();

        while (result.size() < amount) {
            int index = random.nextInt(questionsList.size());
            result.add(questionsList.get(index));
        }

        return result;
    }
}
