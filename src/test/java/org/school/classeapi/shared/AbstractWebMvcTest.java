package org.school.classeapi.shared;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Classe abstraite de base pour les tests de l'API Student. Cette classe fournit des configurations
 * communes pour les tests, telles que l'initialisation d'un générateur de données aléatoires
 * (EasyRandom) avant chaque test.
 */
@TestInstance(Lifecycle.PER_CLASS)
@ActiveProfiles(AbstractWebMvcTest.TEST_PROFILE)
public abstract class AbstractWebMvcTest {

  static final String TEST_PROFILE = "test";

  protected MockMvc mvc;

  @Autowired
  private ObjectMapper objectMapper;

  protected EasyRandom generator;

  @Autowired
  WebApplicationContext webApplicationContext;

  /**
   * Méthode de configuration exécutée avant chaque test pour initialiser les ressources communes.
   */
  protected void setUp() {
    mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    generator = new EasyRandom();
  }

  protected <T> T mapFromJson(String jsonValue, TypeReference<T> clazz)
      throws JsonProcessingException {
    return StringUtils.isNoneBlank(jsonValue) ? objectMapper.readValue(jsonValue, clazz) : null;
  }

  protected String mapToJson(Object object) throws JsonProcessingException {
    return ObjectUtils.isNotEmpty(object) ? objectMapper.writeValueAsString(object) : null;
  }
}
