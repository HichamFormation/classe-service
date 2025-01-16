package org.school.classeapi.web;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.school.classeapi.dto.ClassDto;
import org.school.classeapi.services.ClassService;
import org.school.classeapi.shared.AbstractWebMvcTest;
import org.school.classeapi.shared.TestsHelper;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Classe de test pour la classe {@link ClassController}.
 * Utilise Mockito pour simuler le comportement du service.
 */
@WebMvcTest(ClassControllerImpl.class)
class ClasseControllerTest extends AbstractWebMvcTest {

  @MockBean
  private ClassService classService;

  @BeforeAll
  public void beforeAllTests() {
    this.setUp();
  }

  /**
   * Teste le scénario où une liste d'étudiants associés à un niveau de département spécifié est
   * récupérée avec succès. Vérifie que le statut de la réponse est OK, que le nombre d'étudiants
   * correspond à celui attendu, et que les propriétés des étudiants sont correctes.
   *
   * @throws Exception si une erreur survient pendant le test.
   */
  @Test
  void givenClassDto_whenFindingClassById_thenReturnClassDto()
      throws Exception {

    // GIVEN
    Long classId = 1L;
    ClassDto classDto = generator.nextObject(ClassDto.class);
    classDto.setId(classId);

    // WHEN
    when(classService.findById(1L)).thenReturn(classDto);

    // THEN
    MvcResult result = mvc.perform(
        get(TestsHelper.CLASS_CONTROLLER_REQUEST_MAPPING .concat("/{id}"), classId)
            .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
    String responseJson = result.getResponse().getContentAsString();
    var actualClass = mapFromJson(responseJson,
        new TypeReference<ClassDto>() {
        });
    assertEquals(200, result.getResponse().getStatus());
    assertEquals(1L,actualClass.getId());
    verify(classService, times(1)).findById(classId);
  }

}