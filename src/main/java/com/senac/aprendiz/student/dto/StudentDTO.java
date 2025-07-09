package com.senac.aprendiz.student.dto;

import java.util.UUID;

public record StudentDTO(
    UUID studentId, String name, String telephone, String company, String photoPath) {}
