package com.org.skypro.java.course2.service.test;

import com.org.skypro.java.course2.ExaminerService.Service.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.org.skypro.java.course2.ExaminerService.Question;
import java.util.Collection;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

class JavaQuestionServiceTest {

    private JavaQuestionService service;

    @BeforeEach
    void setUp() {
        service = new JavaQuestionService();
    }

    @Test
    void getAll_whenEmpty_shouldReturnEmptyCollection() {
        Collection<Question> questions = service.getAll();

        assertThat(questions).isEmpty();
    }

    @Test
    void remove_whenEmpty_shouldThrowException() {
        Question q = new Question("Q", "A");

        assertThatThrownBy(() -> service.remove(q))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void add_duplicateQuestion_shouldNotCreateDuplicate() {
        service.add("Q", "A");
        service.add("Q", "A");

        Collection<Question> questions = service.getAll();

        assertThat(questions).hasSize(1);
    }

    @Test
    void getRandomQuestion_whenEmpty_shouldThrowException() {
        assertThatThrownBy(() -> service.getRandomQuestion())
                .isInstanceOf(NoSuchElementException.class);
    }
}
