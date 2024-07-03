package org.school.classeapi.web;

import java.util.List;
import org.school.classeapi.dto.ClassDto;
import org.school.classeapi.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/api/classes")
public class ClassControllerImpl implements ClassController {

  @Autowired
  private ClassService classService;

  @GetMapping(path = "/{id}", name = "FindClasse")
  public ResponseEntity<ClassDto> findById(@PathVariable(value = "id") Long id) {
    return ResponseEntity.ok(classService.findById(id));
  }

  @GetMapping(name = "FindAllClasses", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<List<ClassDto>> findAllClasses() {
    return ResponseEntity.ok(classService.getAllClasses());
  }


  @PostMapping(name = "AddNewClass", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Void> saveClass(@RequestBody ClassDto classDto, UriComponentsBuilder ucb) {
    // Dans cette étape, on sauvegarde la classe dans la base
    ClassDto savedClass = classService.save(classDto);
    UriComponents uc = ucb.path("/api/classes/{id}").buildAndExpand(savedClass.getId());
    HttpHeaders header = new HttpHeaders();
    header.setLocation(uc.toUri());
    return ResponseEntity.status(HttpStatus.CREATED).headers(header).build();
  }

  @PutMapping(name = "UpdateClass", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<ClassDto> updateClass(@RequestBody ClassDto classDto) {
    classService.save(classDto);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(path = "/{id}", name = "DeleteClass")
  public ResponseEntity<String> deleteClass(@PathVariable(value = "id") Long id) {
    classService.deleteClassById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
