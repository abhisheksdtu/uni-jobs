package com.project.unijobs.mapper;

import com.project.unijobs.dto.JobDTO;
import com.project.unijobs.entity.Job;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface JobMapper extends EntityMapper<JobDTO, Job> {
}
