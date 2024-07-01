package com.project.unijobs.mapper;

import com.project.unijobs.dto.AdminDTO;
import com.project.unijobs.entity.Admin;
import org.mapstruct.*;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface AdminMapper extends EntityMapper<AdminDTO, Admin> {

    void update(@MappingTarget Admin entity, AdminDTO dto);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Admin entity, AdminDTO dto);
}
