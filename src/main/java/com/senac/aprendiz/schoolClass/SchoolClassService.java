package com.senac.aprendiz.schoolClass;

import com.senac.aprendiz.schoolClass.dto.SchoolClassDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class SchoolClassService {

  private final SchoolClassRepository repository;

  SchoolClassDTO create(SchoolClassDTO SchoolClassDTO) {
    return SchoolClassMapper.toDto(repository.save(SchoolClassMapper.toEntity(SchoolClassDTO)));
  }

  List<SchoolClassDTO> findAll() {
    return repository.findAll().stream().map(SchoolClassMapper::toDto).toList();
  }

  SchoolClassDTO findById(Long id) {
    return SchoolClassMapper.toDto(
        repository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
  }

  SchoolClassDTO update(Long id, SchoolClassDTO SchoolClassDTO) {
    var coordinator =
        repository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    BeanUtils.copyProperties(SchoolClassDTO, coordinator);

    return SchoolClassMapper.toDto(repository.save(coordinator));
  }

  void delete(Long id) {
    repository.deleteById(id);
  }
}
