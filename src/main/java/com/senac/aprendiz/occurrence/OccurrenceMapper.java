package com.senac.aprendiz.occurrence;

import com.senac.aprendiz.occurrence.dto.OccurrenceDTO;

public class OccurrenceMapper {

  static Occurrence toEntity(OccurrenceDTO occurrenceDTO) {
    return new Occurrence(
        occurrenceDTO.occurrenceId(),
        occurrenceDTO.title(),
        occurrenceDTO.description(),
        null,
        null,
        null);
  }

  static OccurrenceDTO toDto(Occurrence occurrence) {
    return new OccurrenceDTO(
        occurrence.getOccurrenceId(), occurrence.getTitle(), occurrence.getDescription());
  }
}
