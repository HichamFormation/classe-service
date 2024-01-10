package org.school.classeapi.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * La classe abstraite BaseEntity est une classe de base pour toutes les entités de l'application,
 * fournissant des informations d'audit telles que l'utilisateur qui a créé et modifié l'entité,
 * ainsi que les dates de création et de dernière modification.
 *
 */
@Data
@NoArgsConstructor@AllArgsConstructor
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseEntity {

  /**
   * Utilisateur qui a créé l'entité.
   */
  @CreatedBy
  @Column(name = "created_by")
  private String createdBy;

  /**
   * Date et heure de création de l'entité.
   */
  @CreatedDate
  @Column(name = "created_date")
  private LocalDateTime createdDate;

  /**
   * Utilisateur qui a modifié l'entité pour la dernière fois.
   */
  @LastModifiedBy
  @Column(name = "last_modified_by")
  private String lastModifiedBy;

  /**
   * Date et heure de la dernière modification de l'entité.
   */
  @LastModifiedDate
  @Column(name = "last_modified_date")
  private LocalDateTime lastModifiedDate;

}
