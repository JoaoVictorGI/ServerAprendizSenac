package com.senac.aprendiz.student;

import com.senac.aprendiz.occurrence.Occurrence;
import com.senac.aprendiz.schoolClass.SchoolClass;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID studentId;

  private String name;

  private String telephone;

  private String company;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "schoolClassId")
  private SchoolClass schoolClass;

  /*
   * @Lob @Basic(fetch = FetchType.LAZY)
   * @Column(columnDefinition = "bytea")
   * private byte[] photo
   */
  private String photoPath;

  @OneToMany(mappedBy = "student")
  private List<Occurrence> occurrences;
}
