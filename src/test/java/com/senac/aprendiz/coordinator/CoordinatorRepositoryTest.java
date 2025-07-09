package com.senac.aprendiz.coordinator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class CoordinatorRepositoryTest {

  @Autowired CoordinatorRepository repository;
  @Autowired TestEntityManager entityManager;

  private Coordinator testCoordinator;

  @BeforeEach
  void setUp() {
    testCoordinator = new Coordinator(null, "name", "password", null);
    repository.save(testCoordinator);
  }

  void givenNewCoordinator_whenCreated_thenSuccess() {
    assertNotNull(testCoordinator);
  }

  @Test
  void givenID_whenSelected_thenCoordinatorIsFound() {
    var foundCoordinator = repository.findById(testCoordinator.getCoordinatorId());

    assertEquals(testCoordinator, foundCoordinator.get());
  }

  @Test
  void givenID_whenUpdated_thenCanBeFoundWithUpdatedData() {
    testCoordinator.setUsername("updatedName");
    repository.save(testCoordinator);

    var updatedCoordinator =
        repository.findById(testCoordinator.getCoordinatorId()).orElseGet(null);

    assertNotNull(updatedCoordinator);
    assertEquals("updatedName", updatedCoordinator.getUsername());
  }

  @Test
  void givenID_whenDeleted_thenCannotBeFound() {
    repository.deleteById(testCoordinator.getCoordinatorId());
    var deletedCoordinator = repository.findById(testCoordinator.getCoordinatorId()).orElse(null);

    assertNull(deletedCoordinator);
  }
}
