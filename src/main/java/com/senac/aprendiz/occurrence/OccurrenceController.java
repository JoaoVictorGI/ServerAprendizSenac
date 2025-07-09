package com.senac.aprendiz.occurrence;

import com.senac.aprendiz.occurrence.dto.OccurrenceDTO;
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
@RequestMapping("/occurrence")
public class OccurrenceController {

  private final OccurrenceService service;

  @PostMapping
  ResponseEntity<OccurrenceDTO> create(@RequestBody OccurrenceDTO OccurrenceDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.create(OccurrenceDTO));
  }

  @GetMapping
  ResponseEntity<List<OccurrenceDTO>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  ResponseEntity<OccurrenceDTO> findById(@PathVariable UUID id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @PutMapping("/{id}")
  ResponseEntity<OccurrenceDTO> update(
      @PathVariable UUID id, @RequestBody OccurrenceDTO OccurrenceDTO) {
    return ResponseEntity.ok(service.update(id, OccurrenceDTO));
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Object> delete(@PathVariable UUID id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
