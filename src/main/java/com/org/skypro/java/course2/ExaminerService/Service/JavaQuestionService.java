package com.org.skypro.java.course2.ExaminerService.Service;

import java.util.*;

import com.org.skypro.java.course2.ExaminerService.Question;
import org.springframework.stereotype.Service;

public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        questions.add(q);
        return q;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new IllegalStateException("Список вопросов пуст");
        }

        int index = random.nextInt(questions.size());

        return questions.stream()
                .skip(index)
                .findFirst()
                .orElseThrow()
                ;
    }
}
