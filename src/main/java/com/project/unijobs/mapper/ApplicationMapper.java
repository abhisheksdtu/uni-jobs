package com.project.unijobs.mapper;

import com.project.unijobs.dto.ApplicationDTO;
import com.project.unijobs.entity.Application;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ApplicationMapper extends EntityMapper<ApplicationDTO, Application> {
}
