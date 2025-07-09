package com.senac.aprendiz.student;

import com.senac.aprendiz.student.dto.StudentDTO;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentRepository repository;

  StudentDTO create(StudentDTO StudentDTO) {
    return StudentMapper.toDto(repository.save(StudentMapper.toEntity(StudentDTO)));
  }

  List<StudentDTO> findAll() {
    return repository.findAll().stream().map(StudentMapper::toDto).toList();
  }

  StudentDTO findById(UUID id) {
    return StudentMapper.toDto(
        repository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
  }

  StudentDTO update(UUID id, StudentDTO StudentDTO) {
    var Student =
        repository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    BeanUtils.copyProperties(StudentDTO, Student);

    return StudentMapper.toDto(repository.save(Student));
  }

  void delete(UUID id) {
    repository.deleteById(id);
  }
}
