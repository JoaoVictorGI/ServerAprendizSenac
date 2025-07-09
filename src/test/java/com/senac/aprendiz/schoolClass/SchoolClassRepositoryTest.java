package com.senac.aprendiz.schoolClass;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class SchoolClassRepositoryTest {
  @Autowired SchoolClassRepository repository;
  @Autowired TestEntityManager entityManager;

  private SchoolClass testSchoolClass;

  @BeforeEach
  void setUp() {
    testSchoolClass = new SchoolClass(null, "name", null, null);
    repository.save(testSchoolClass);
  }

  void givenNewSchoolClass_whenCreated_thenSuccess() {
    assertNotNull(testSchoolClass);
  }

  @Test
  void givenID_whenSelected_thenSchoolClassIsFound() {
    var foundSchoolClass = repository.findById(testSchoolClass.getSchoolClassId());

    assertEquals(testSchoolClass, foundSchoolClass.get());
  }

  @Test
  void givenID_whenUpdated_thenCanBeFoundWithUpdatedData() {
    testSchoolClass.setName("updatedName");
    repository.save(testSchoolClass);

    var updatedSchoolClass =
        repository.findById(testSchoolClass.getSchoolClassId()).orElseGet(null);

    assertNotNull(updatedSchoolClass);
    assertEquals("updatedName", updatedSchoolClass.getName());
  }

  @Test
  void givenID_whenDeleted_thenCannotBeFound() {
    repository.deleteById(testSchoolClass.getSchoolClassId());
    var deletedSchoolClass = repository.findById(testSchoolClass.getSchoolClassId()).orElse(null);

    assertNull(deletedSchoolClass);
  }
}
