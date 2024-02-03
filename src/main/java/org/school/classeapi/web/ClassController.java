package org.school.classeapi.web;

import java.util.List;
import org.school.classeapi.dto.ClassDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface ClassController {

  ResponseEntity<List<ClassDto>> findAllClasses();

  ResponseEntity<Void> saveClass(ClassDto classDto, UriComponentsBuilder ucb);

  ResponseEntity<ClassDto> updateClass(ClassDto classDto);

  ResponseEntity<String> deleteClass(Long id);

}
