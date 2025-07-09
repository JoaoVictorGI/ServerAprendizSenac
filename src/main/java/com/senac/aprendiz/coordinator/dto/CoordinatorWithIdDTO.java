package com.senac.aprendiz.coordinator.dto;

import java.util.UUID;

public record CoordinatorWithIdDTO(UUID coordinatorId, String username, String password) {}
