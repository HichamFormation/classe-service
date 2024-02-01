package org.school.classeapi.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.school.classeapi.dto.ClassDto;
import org.school.classeapi.entities.ClassEntity;

@Mapper(componentModel = "spring")
public interface ClassMapper {

  ClassMapper MAPPER = Mappers.getMapper(ClassMapper.class);

  ClassEntity convertDtoToEntity(ClassDto classDto);

  ClassDto convertEntityToDto(ClassEntity classEntity);

  List<ClassDto> convertEntityToDtos(List<ClassEntity> classEntities);


}
