package com.org.skypro.java.course2.service.test;

import com.org.skypro.java.course2.ExaminerService.Question;
import com.org.skypro.java.course2.ExaminerService.Service.ExaminerServiceImpl;
import com.org.skypro.java.course2.ExaminerService.Service.QuestionService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestions_whenEmptyCollection_shouldReturnEmpty() {
        when(questionService.getAll()).thenReturn(List.of());

        Collection<Question> result = examinerService.getQuestions(0);

        assertThat(result).isEmpty();
    }

    @Test
    void getQuestions_amountZero_shouldReturnEmpty() {
        when(questionService.getAll()).thenReturn(
                List.of(new Question("Q1", "A1"))
        );

        Collection<Question> result = examinerService.getQuestions(0);

        assertThat(result).isEmpty();
    }

    @Test
    void getQuestions_whenAmountMoreThanAvailable_shouldThrowException() {
        when(questionService.getAll()).thenReturn(
                List.of(new Question("Q1", "A1"))
        );

        assertThatThrownBy(() -> examinerService.getQuestions(2))
                .isInstanceOf(ResponseStatusException.class);
    }

    @Test
    void getQuestions_shouldReturnUniqueQuestions() {
        Question q1 = new Question("Q1", "A1");
        Question q2 = new Question("Q2", "A2");

        when(questionService.getAll()).thenReturn(List.of(q1, q2));

        Collection<Question> result = examinerService.getQuestions(2);

        assertThat(result).hasSize(2);
        assertThat(result).containsExactlyInAnyOrder(q1, q2);
    }
}
