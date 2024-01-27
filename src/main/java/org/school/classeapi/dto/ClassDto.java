package org.school.classeapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) représentant les informations d'une classe.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassDto {

  /**
   * Identifiant de la classe.
   */
  private Long id;

  /**
   * Nom de la classe.
   */
  @NotBlank
  private String name;

  /**
   * Étage de la classe.
   */
  @NotBlank
  private String floor;

  /**
   * Nombre de places dans la classe.
   */
  @NotBlank
  private int nombrePlace;
}
