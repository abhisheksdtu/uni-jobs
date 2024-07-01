package com.project.unijobs.mapper;

import com.project.unijobs.dto.RecruiterDTO;
import com.project.unijobs.entity.Recruiter;
import org.mapstruct.BeanMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface RecruiterMapper extends EntityMapper<RecruiterDTO, Recruiter> {

    void update(@MappingTarget Recruiter entity, RecruiterDTO dto);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Recruiter entity, RecruiterDTO dto);
}
