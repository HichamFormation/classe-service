package org.school.classeapi.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import java.util.Locale;

/**
 * Cette classe de configuration détermine la configuration de l'internationalisation (i18n) dans l'application.
 * Elle permet de charger les fichiers de messages pour différentes langues et de définir les paramètres
 * de l'internationalisation.
 */
@Configuration
public class InternationalizationConfig {

    /**
     * Crée et configure le bean de messages pour la gestion de l'internationalisation.
     *
     * @return Le bean de messages configuré.
     */
    @Bean
    public ResourceBundleMessageSource messageSource(){
        var messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("resource");
        messageSource.setDefaultLocale(Locale.FRENCH);
        messageSource.setDefaultEncoding("ISO-8859-1");
        return messageSource;
    }
}