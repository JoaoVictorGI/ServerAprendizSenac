package com.senac.aprendiz.coordinator;

import com.senac.aprendiz.coordinator.dto.CoordinatorDTO;
import com.senac.aprendiz.coordinator.dto.CoordinatorWithIdDTO;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coordinator")
public class CoordinatorController {

  private final CoordinatorService service;

  @PostMapping
  ResponseEntity<CoordinatorWithIdDTO> create(@RequestBody CoordinatorDTO coordinatorDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.create(coordinatorDTO));
  }

  @GetMapping
  ResponseEntity<List<CoordinatorDTO>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  ResponseEntity<CoordinatorDTO> findById(@PathVariable UUID id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @PutMapping("/{id}")
  ResponseEntity<CoordinatorDTO> update(
      @PathVariable UUID id, @RequestBody CoordinatorDTO coordinatorDTO) {
    return ResponseEntity.ok(service.update(id, coordinatorDTO));
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Object> delete(@PathVariable UUID id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
