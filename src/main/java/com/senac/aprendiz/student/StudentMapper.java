package com.senac.aprendiz.student;

import com.senac.aprendiz.student.dto.StudentDTO;

public class StudentMapper {

  static Student toEntity(StudentDTO studentDTO) {
    return new Student(
        studentDTO.studentId(),
        studentDTO.name(),
        studentDTO.telephone(),
        studentDTO.company(),
        null,
        studentDTO.photoPath(),
        null);
  }

  static StudentDTO toDto(Student student) {
    return new StudentDTO(
        student.getStudentId(),
        student.getName(),
        student.getTelephone(),
        student.getCompany(),
        student.getPhotoPath());
  }
}
