package com.senac.aprendiz.coordinator;

import com.senac.aprendiz.coordinator.dto.CoordinatorDTO;
import com.senac.aprendiz.coordinator.dto.CoordinatorWithIdDTO;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CoordinatorService {

  private final CoordinatorRepository repository;

  CoordinatorWithIdDTO create(CoordinatorDTO coordinatorDTO) {
    return CoordinatorMapper.toWithIdDto(
        repository.save(CoordinatorMapper.toEntity(coordinatorDTO)));
  }

  List<CoordinatorDTO> findAll() {
    return repository.findAll().stream().map(CoordinatorMapper::toDto).toList();
  }

  CoordinatorDTO findById(UUID id) {
    return CoordinatorMapper.toDto(
        repository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
  }

  CoordinatorDTO update(UUID id, CoordinatorDTO coordinatorDTO) {
    var coordinator =
        repository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    BeanUtils.copyProperties(coordinatorDTO, coordinator);

    return CoordinatorMapper.toDto(repository.save(coordinator));
  }

  void delete(UUID id) {
    repository.deleteById(id);
  }
}
