package org.school.classeapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.school.classeapi.base.BaseEntity;

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

}
