package org.school.classeapi.shared;

import lombok.Getter;

/**
 * Cette classe représente une exception métier personnalisée utilisée pour encapsuler des erreurs métier spécifiques.
 * Elle hérite de la classe RuntimeException et permet de fournir des informations détaillées sur l'erreur métier.
 * Lorsqu'une instance de BusinessException est levée, elle contient le type d'erreur métier associé.
 */
@Getter
public class BusinessException extends RuntimeException {
    // Le type d'erreur métier associé à cette exception.
    private final ClassMessage errorMessage;
    private final String code;

    /**
     * Construit une nouvelle instance de BusinessException avec le message d'erreur métier spécifié.
     *
     * @param message Le type d'erreur métier à encapsuler dans cette exception.
     */
    public BusinessException(ClassMessage message) {
        super(message.name());
        this.errorMessage=message;
        this.code=message.name();
    }
}
