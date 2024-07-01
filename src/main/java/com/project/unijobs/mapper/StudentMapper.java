package com.project.unijobs.mapper;

import com.project.unijobs.dto.StudentDTO;
import com.project.unijobs.entity.Student;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface StudentMapper extends EntityMapper<StudentDTO, Student> {
}
