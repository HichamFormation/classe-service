package org.school.classeapi.config;

import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * La classe WebConfig est une classe de configuration Spring responsable de la configuration
 * de l'audit JPA. Elle active l'auditing JPA en utilisant l'annotation `@EnableJpaAuditing`,
 * et spécifie la référence à l'implémentation de l'interface AuditorAware à utiliser.
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AuditAwareConfiguration {

  /**
   * Méthode de configuration qui crée et retourne une instance de l'implémentation
   * de l'interface AuditorAware à utiliser pour récupérer l'identifiant de l'auditeur.
   *
   * @return Une instance de l'implémentation de l'interface AuditorAware, en l'occurrence
   *         AuditorAwareImpl.
   */
  @Bean
  public AuditorAware<String> auditorAware () {
    return () -> Optional.of("test user");
  }

}
