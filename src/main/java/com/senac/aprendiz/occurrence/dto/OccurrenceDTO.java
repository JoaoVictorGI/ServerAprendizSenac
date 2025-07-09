package com.senac.aprendiz.occurrence.dto;

import java.util.UUID;

public record OccurrenceDTO(UUID occurrenceId, String title, String description) {}
