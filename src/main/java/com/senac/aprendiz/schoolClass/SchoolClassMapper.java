package com.senac.aprendiz.schoolClass;

import com.senac.aprendiz.schoolClass.dto.SchoolClassDTO;

public class SchoolClassMapper {
  static SchoolClassDTO toDto(SchoolClass schoolClass) {
    return new SchoolClassDTO(schoolClass.getSchoolClassId(), schoolClass.getName());
  }

  static SchoolClass toEntity(SchoolClassDTO schoolClassDTO) {
    return new SchoolClass(schoolClassDTO.schoolClassId(), schoolClassDTO.name(), null, null);
  }
}
