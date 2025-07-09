package com.senac.aprendiz.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class StudentRepositoryTest {

  @Autowired StudentRepository repository;
  @Autowired TestEntityManager entityManager;

  private Student testStudent;

  @BeforeEach
  void setUp() {
    testStudent = new Student(null, "name", "telephone", "company", null, null, null);
    repository.save(testStudent);
  }

  void givenNewStudent_whenCreated_thenSuccess() {
    assertNotNull(testStudent);
  }

  @Test
  void givenID_whenSelected_thenStudentIsFound() {
    var foundStudent = repository.findById(testStudent.getStudentId());

    assertEquals(testStudent, foundStudent.get());
  }

  @Test
  void givenID_whenUpdated_thenCanBeFoundWithUpdatedData() {
    testStudent.setName("updatedName");
    repository.save(testStudent);

    var updatedStudent = repository.findById(testStudent.getStudentId()).orElseGet(null);

    assertNotNull(updatedStudent);
    assertEquals("updatedName", updatedStudent.getName());
  }

  @Test
  void givenID_whenDeleted_thenCannotBeFound() {
    repository.deleteById(testStudent.getStudentId());
    var deletedStudent = repository.findById(testStudent.getStudentId()).orElse(null);

    assertNull(deletedStudent);
  }
}
