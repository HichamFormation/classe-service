package org.school.classeapi.shared;


import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Classe abstraite de base pour les tests de l'API Student. Cette classe fournit des configurations
 * communes pour les tests, telles que l'initialisation d'un générateur de données aléatoires
 * (EasyRandom) avant chaque test.
 */

@DataJpaTest
@TestInstance(Lifecycle.PER_CLASS)
@ActiveProfiles(AbstractDaoTest.TEST_PROFILE)
public abstract class AbstractDaoTest {

  static final String TEST_PROFILE = "test";

  protected EasyRandom generator;

  protected void setUp() {
    generator = new EasyRandom();
  }

}
