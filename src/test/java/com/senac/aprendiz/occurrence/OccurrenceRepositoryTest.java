package com.senac.aprendiz.occurrence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Instant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class OccurrenceRepositoryTest {

  @Autowired OccurrenceRepository repository;
  @Autowired TestEntityManager entityManager;

  private Occurrence testOccurrence;

  @BeforeEach
  void setUp() {
    testOccurrence =
        new Occurrence(null, "title", "description", Instant.now(), Instant.now(), null);
    repository.save(testOccurrence);
  }

  void givenNewOccurrence_whenCreated_thenSuccess() {
    assertNotNull(testOccurrence);
  }

  @Test
  void givenID_whenSelected_thenOccurrenceIsFound() {
    var foundOccurrence = repository.findById(testOccurrence.getOccurrenceId());

    assertEquals(testOccurrence, foundOccurrence.get());
  }

  @Test
  void givenID_whenUpdated_thenCanBeFoundWithUpdatedData() {
    testOccurrence.setTitle("updatedTitle");
    repository.save(testOccurrence);

    var updatedOccurrence = repository.findById(testOccurrence.getOccurrenceId()).orElseGet(null);

    assertNotNull(updatedOccurrence);
    assertEquals("updatedTitle", updatedOccurrence.getTitle());
  }

  @Test
  void givenID_whenDeleted_thenCannotBeFound() {
    repository.deleteById(testOccurrence.getOccurrenceId());
    var deletedOccurrence = repository.findById(testOccurrence.getOccurrenceId()).orElse(null);

    assertNull(deletedOccurrence);
  }
}
