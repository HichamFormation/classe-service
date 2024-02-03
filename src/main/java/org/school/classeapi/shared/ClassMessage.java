package org.school.classeapi.shared;

import org.springframework.http.HttpStatus;

/**
 * Cette énumération définit les messages d'erreur possibles associés aux exceptions de
 * l'application. Chaque valeur de l'énumération correspond à un type d'erreur spécifique.
 */
public enum ClassMessage {

  // Indique que l'étudiant recherché n'a pas été trouvé.
  CLASS_NOT_FOUND,
  // Indique que l'âge de l'étudiant n'est pas valide.
  FLOOR_NOT_VALID,
  // Indique que un ou plusieurs paramètres en entrée sont invalides.
  ARGUMENTS_NOT_VALID;

  public String getMessage() {
    return this.name();
  }

  /**
   * Convertit le message d'erreur en un code de statut HTTP approprié.
   *
   * @return Le code de statut HTTP correspondant au message d'erreur.
   */
  public HttpStatus toHttpStatus() {
    switch (this) {
      case ARGUMENTS_NOT_VALID:
        return HttpStatus.UNPROCESSABLE_ENTITY;
      case CLASS_NOT_FOUND:
        return HttpStatus.NOT_FOUND;
      case FLOOR_NOT_VALID:
        return HttpStatus.BAD_REQUEST;
      default:
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
  }
}