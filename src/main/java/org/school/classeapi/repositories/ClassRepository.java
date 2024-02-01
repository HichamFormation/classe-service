package org.school.classeapi.repositories;

import org.school.classeapi.entities.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {

  
}
