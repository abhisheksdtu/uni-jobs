package com.project.unijobs.mapper;

import com.project.unijobs.dto.RecruiterDTO;
import com.project.unijobs.entity.Recruiter;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface RecruiterMapper extends EntityMapper<RecruiterDTO, Recruiter> {
}
