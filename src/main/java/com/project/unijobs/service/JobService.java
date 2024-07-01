package com.project.unijobs.service;

import com.project.unijobs.dto.JobDTO;
import com.project.unijobs.entity.Job;
import com.project.unijobs.mapper.JobMapper;
import com.project.unijobs.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService {
    private final JobRepository jobRepository;
    private final JobMapper jobMapper;

    public JobService(JobRepository jobRepository,
                      JobMapper jobMapper) {
        this.jobRepository = jobRepository;
        this.jobMapper = jobMapper;
    }

    public JobDTO create(JobDTO jobDTO) {
        Job job = jobMapper.toEntity(jobDTO);
        job = jobRepository.save(job);
        return jobMapper.toDto(job);
    }

    public JobDTO update(JobDTO jobDTO) {
        Job job = jobRepository.findById(jobDTO.getId())
                .orElseThrow(() -> new RuntimeException("Job not found"));
        jobMapper.update(job, jobDTO);
        job = jobRepository.save(job);
        return jobMapper.toDto(job);
    }

    public JobDTO partialUpdate(JobDTO jobDTO) {
        Job job = jobRepository.findById(jobDTO.getId())
                .orElseThrow(() -> new RuntimeException("Job not found"));
        jobMapper.partialUpdate(job, jobDTO);
        job = jobRepository.save(job);
        return jobMapper.toDto(job);
    }

    public JobDTO getById(Integer id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));
        return jobMapper.toDto(job);
    }

    public void delete(Integer id) {
        jobRepository.deleteById(id);
    }

    public List<JobDTO> getAll() {
        return jobRepository.findAll().stream()
                .map(jobMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<JobDTO> search(String title,
                               String location,
                               String type) {
        return jobRepository.findByJobTitleContainingAndLocationContainingAndJobTypeContaining(
                        title != null ? title : "",
                        location != null ? location : "",
                        type != null ? type : ""
                ).stream()
                .map(jobMapper::toDto)
                .collect(Collectors.toList());
    }
}
