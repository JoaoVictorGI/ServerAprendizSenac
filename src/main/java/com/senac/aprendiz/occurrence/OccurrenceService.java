package com.senac.aprendiz.occurrence;

import com.senac.aprendiz.occurrence.dto.OccurrenceDTO;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class OccurrenceService {

  private final OccurrenceRepository repository;

  OccurrenceDTO create(OccurrenceDTO OccurrenceDTO) {
    return OccurrenceMapper.toDto(repository.save(OccurrenceMapper.toEntity(OccurrenceDTO)));
  }

  List<OccurrenceDTO> findAll() {
    return repository.findAll().stream().map(OccurrenceMapper::toDto).toList();
  }

  OccurrenceDTO findById(UUID id) {
    return OccurrenceMapper.toDto(
        repository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
  }

  OccurrenceDTO update(UUID id, OccurrenceDTO OccurrenceDTO) {
    var coordinator =
        repository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    BeanUtils.copyProperties(OccurrenceDTO, coordinator);

    return OccurrenceMapper.toDto(repository.save(coordinator));
  }

  void delete(UUID id) {
    repository.deleteById(id);
  }
}
