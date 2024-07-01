package com.project.unijobs.mapper;

import com.project.unijobs.dto.ApplicationDTO;
import com.project.unijobs.entity.Application;
import org.mapstruct.*;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ApplicationMapper extends EntityMapper<ApplicationDTO, Application> {

    void update(@MappingTarget Application entity, ApplicationDTO dto);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Application entity, ApplicationDTO dto);
}
