package com.senac.aprendiz.occurrence;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccurrenceRepository
    extends JpaRepository<Occurrence, UUID>, RevisionRepository<Occurrence, UUID, Long> {}
