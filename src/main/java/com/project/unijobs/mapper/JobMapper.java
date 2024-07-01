package com.project.unijobs.mapper;

import com.project.unijobs.dto.JobDTO;
import com.project.unijobs.entity.Job;
import org.mapstruct.*;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface JobMapper extends EntityMapper<JobDTO, Job> {

    void update(@MappingTarget Job entity, JobDTO dto);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Job entity, JobDTO dto);
}
