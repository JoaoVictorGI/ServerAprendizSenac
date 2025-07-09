package com.senac.aprendiz.coordinator;

import com.senac.aprendiz.schoolClass.SchoolClass;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Coordinator {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID coordinatorId;

  private String username;

  private String password;

  @OneToMany(mappedBy = "coordinator")
  private List<SchoolClass> classes;
}
