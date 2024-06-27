package com.project.unijobs.mapper;

import com.project.unijobs.dto.AdminDTO;
import com.project.unijobs.entity.Admin;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface AdminMapper extends EntityMapper<AdminDTO, Admin> {
}
