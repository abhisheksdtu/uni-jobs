package com.project.unijobs.mapper;

import com.project.unijobs.dto.StudentDTO;
import com.project.unijobs.entity.Student;
import org.mapstruct.*;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface StudentMapper extends EntityMapper<StudentDTO, Student> {

    void update(@MappingTarget Student entity, StudentDTO dto);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Student entity, StudentDTO dto);
}
