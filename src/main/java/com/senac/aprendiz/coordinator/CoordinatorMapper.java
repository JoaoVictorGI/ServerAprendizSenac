package com.senac.aprendiz.coordinator;

import com.senac.aprendiz.coordinator.dto.CoordinatorDTO;
import com.senac.aprendiz.coordinator.dto.CoordinatorWithIdDTO;

class CoordinatorMapper {
  static Coordinator toEntity(CoordinatorDTO coordinatorDTO) {
    return new Coordinator(null, coordinatorDTO.username(), coordinatorDTO.password(), null);
  }

  static Coordinator withIdToEntity(CoordinatorWithIdDTO coordinatorDTO) {
    return new Coordinator(
        coordinatorDTO.coordinatorId(), coordinatorDTO.username(), coordinatorDTO.password(), null);
  }

  static CoordinatorDTO toDto(Coordinator coordinator) {
    return new CoordinatorDTO(coordinator.getUsername(), coordinator.getPassword());
  }

  static CoordinatorWithIdDTO toWithIdDto(Coordinator coordinator) {
    return new CoordinatorWithIdDTO(
        coordinator.getCoordinatorId(), coordinator.getUsername(), coordinator.getPassword());
  }
}
