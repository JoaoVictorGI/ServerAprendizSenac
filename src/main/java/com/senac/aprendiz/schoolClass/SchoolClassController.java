package com.senac.aprendiz.schoolClass;

import com.senac.aprendiz.schoolClass.dto.SchoolClassDTO;
import java.util.List;
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
@RequestMapping("/class")
public class SchoolClassController {

  private final SchoolClassService service;

  @PostMapping
  ResponseEntity<SchoolClassDTO> create(@RequestBody SchoolClassDTO SchoolClassDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.create(SchoolClassDTO));
  }

  @GetMapping
  ResponseEntity<List<SchoolClassDTO>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  ResponseEntity<SchoolClassDTO> findById(@PathVariable Long id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @PutMapping("/{id}")
  ResponseEntity<SchoolClassDTO> update(
      @PathVariable Long id, @RequestBody SchoolClassDTO SchoolClassDTO) {
    return ResponseEntity.ok(service.update(id, SchoolClassDTO));
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Object> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
