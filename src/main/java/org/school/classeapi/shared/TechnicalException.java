package org.school.classeapi.shared;

import lombok.Getter;

/**
 * Cette classe représente une exception technique personnalisée utilisée pour encapsuler des
 * erreurs technique spécifiques. Elle hérite de la classe RuntimeException et permet de fournir des
 * informations détaillées sur l'erreur technique. Lorsqu'une instance de TechnicalException est
 * levée, elle contient le type d'erreur technique associé.
 */
@Getter
public class TechnicalException extends RuntimeException {

  // Le type d'erreur technique associé à cette exception.
  private final ClassMessage errorMessage;
  private final String code;

  /**
   * Construit une nouvelle instance de TechnicalException avec le message d'erreur technique
   * spécifié.
   *
   * @param errorMessage Le type d'erreur technique à encapsuler dans cette exception.
   */
  public TechnicalException(ClassMessage errorMessage) {
    super(errorMessage.name());
    this.errorMessage = errorMessage;
    this.code = errorMessage.name();
  }

}
