package org.school.classeapi.shared;

import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * Cette classe représente une réponse d'erreur qui peut être renvoyée par l'application en cas
 * d'exception. Elle contient des informations sur l'erreur, y compris le message d'erreur, le code
 * de statut, l'heure de l'erreur et des détails supplémentaires.
 */
@Builder
@Data
public class ErrorResponse {

  // Le message d'erreur décrivant l'erreur survenue.
  private String message;
  // Le code de statut HTTP associé à l'erreur.
  private String code;
  // L'heure à laquelle l'erreur s'est produite.
  private Date time;
  //Une liste de détails supplémentaires sur l'erreur (peut être null).
  private List<String> details;

  /**
   * Constructeur de la classe ErrorResponse.
   *
   * @param message Le message d'erreur décrivant l'erreur.
   * @param code    Le code de statut HTTP associé à l'erreur.
   * @param details Une liste de détails supplémentaires sur l'erreur (peut être null).
   */
  public ErrorResponse(String message, String code, Date time, List<String> details) {
    this.message = message;
    this.code = code;
    this.time = time;
    this.details = details;
  }
}
