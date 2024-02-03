package org.school.classeapi.services;

import java.util.List;
import org.school.classeapi.dto.ClassDto;

public interface ClassService {

  ClassDto save(ClassDto classDto);

  List<ClassDto> getAllClasses();

  ClassDto update(ClassDto classDto);

  void deleteClassById(Long id);
}
