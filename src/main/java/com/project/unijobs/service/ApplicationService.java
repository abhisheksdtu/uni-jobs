package com.project.unijobs.service;

import com.project.unijobs.dto.ApplicationDTO;
import com.project.unijobs.entity.Application;
import com.project.unijobs.mapper.ApplicationMapper;
import com.project.unijobs.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;

    public ApplicationService(ApplicationRepository applicationRepository,
                              ApplicationMapper applicationMapper) {
        this.applicationRepository = applicationRepository;
        this.applicationMapper = applicationMapper;
    }

    public ApplicationDTO create(ApplicationDTO applicationDTO) {
        Application application = applicationMapper.toEntity(applicationDTO);
        application = applicationRepository.save(application);
        return applicationMapper.toDto(application);
    }

    public ApplicationDTO update(ApplicationDTO applicationDTO) {
        Application application = applicationRepository.findById(applicationDTO.getId())
                .orElseThrow(() -> new RuntimeException("Application not found"));
        applicationMapper.update(application, applicationDTO);
        application = applicationRepository.save(application);
        return applicationMapper.toDto(application);
    }

    public ApplicationDTO partialUpdate(ApplicationDTO applicationDTO) {
        Application application = applicationRepository.findById(applicationDTO.getId())
                .orElseThrow(() -> new RuntimeException("Application not found"));
        applicationMapper.partialUpdate(application, applicationDTO);
        application = applicationRepository.save(application);
        return applicationMapper.toDto(application);
    }

    public ApplicationDTO getById(Integer id) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        return applicationMapper.toDto(application);
    }

    public void delete(Integer id) {
        applicationRepository.deleteById(id);
    }

    public List<ApplicationDTO> getAll() {
        return applicationRepository.findAll().stream()
                .map(applicationMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<ApplicationDTO> getByStudentId(Integer studentId) {
        return applicationRepository.findByStudentId(studentId)
                .stream()
                .map(applicationMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<ApplicationDTO> getByJobId(Integer jobId) {
        return applicationRepository.findByJobId(jobId)
                .stream()
                .map(applicationMapper::toDto)
                .collect(Collectors.toList());
    }
}
