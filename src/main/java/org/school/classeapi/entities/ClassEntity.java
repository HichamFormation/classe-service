package org.school.classeapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.school.classeapi.base.BaseEntity;
import org.school.classeapi.dto.StudentDto;

import java.util.List;

/**
 * Entité représentant une classe dans dune école.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "class_entity")
public class ClassEntity extends BaseEntity {

  /**
   * Identifiant unique de la classe.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * Nom de la classe.
   */
  @Column(name = "name")
  private String name;

  /**
   * Étage de la classe.
   */
  @Column(name = "floor")
  private String floor;

  /**
   * Nombre de places dans la classe.
   */
  @Column(name = "nbrPlace")
  private int nombrePlace;

  @Transient
  List<StudentDto> students;

}
