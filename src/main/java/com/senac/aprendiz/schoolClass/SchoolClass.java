package com.senac.aprendiz.schoolClass;

import com.senac.aprendiz.coordinator.Coordinator;
import com.senac.aprendiz.student.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "school_class")
public class SchoolClass {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long schoolClassId;

  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "coordinatorId")
  private Coordinator coordinator;

  @OneToMany(mappedBy = "schoolClass")
  private List<Student> students;
}
