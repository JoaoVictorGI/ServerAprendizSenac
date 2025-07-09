package com.senac.aprendiz.occurrence;

import com.senac.aprendiz.student.Student;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Setter
@Getter
@Audited
@NoArgsConstructor
@AllArgsConstructor
public class Occurrence {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID occurrenceId;

  private String title;

  @Nullable private String description;

  @CreatedDate private Instant createdAt;

  @UpdateTimestamp private Instant updatedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "studentId")
  private Student student;
}
