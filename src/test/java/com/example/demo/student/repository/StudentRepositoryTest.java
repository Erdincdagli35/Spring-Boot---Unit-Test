package com.example.demo.student.repository;

import com.example.demo.student.model.Gender;
import com.example.demo.student.model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckWhenStudentEmailExists() {
        //given
        String email = "erdinc@gmail.com";
        Student student = new Student(
                "Erdinç",
                email,
                Gender.MALE
        );
        underTest.save(student);

        //when
        boolean exists = underTest.selectExistsEmail(email);

        //then
        assertThat(exists).isTrue();
    }

    @Test
    void itShouldCheckWhenStudentEmailDoesNotExists() {
        //given
        String email = "erdinc@gmail.com";

        //when
        boolean expected = underTest.selectExistsEmail(email);

        //then
        assertThat(expected).isFalse();
    }
}