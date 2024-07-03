package org.school.classeapi.services;

import java.util.List;
import org.school.classeapi.dto.ClassDto;
import org.school.classeapi.mappers.ClassMapper;
import org.school.classeapi.repositories.ClassRepository;
import org.school.classeapi.shared.BusinessException;
import org.school.classeapi.shared.ClassMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService {

  @Autowired
  private ClassRepository classRepository;

  @Override
  public ClassDto findById(Long id) {
    return ClassMapper.MAPPER.convertEntityToDto(classRepository.findById(id).orElseThrow(() -> new BusinessException(ClassMessage.CLASS_NOT_FOUND)));
  }

  @Override
  public ClassDto save(ClassDto classDto) {
    return ClassMapper.MAPPER.convertEntityToDto(
        classRepository.save(ClassMapper.MAPPER.convertDtoToEntity(classDto)));
  }

  @Override
  public List<ClassDto> getAllClasses() {
    return ClassMapper.MAPPER.convertEntityToDtos(classRepository.findAll());
  }

  @Override
  public ClassDto update(ClassDto classDto) {
    return null;
  }

  @Override
  public void deleteClassById(Long id) {
    classRepository.findById(id)
        .orElseThrow(() -> new BusinessException(ClassMessage.CLASS_NOT_FOUND));
    classRepository.deleteById(id);

  }
}
