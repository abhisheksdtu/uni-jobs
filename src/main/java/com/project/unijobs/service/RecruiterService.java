package com.project.unijobs.service;

import com.project.unijobs.dto.RecruiterDTO;
import com.project.unijobs.entity.Recruiter;
import com.project.unijobs.mapper.RecruiterMapper;
import com.project.unijobs.repository.RecruiterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecruiterService {
    private final RecruiterRepository recruiterRepository;
    private final RecruiterMapper recruiterMapper;

    public RecruiterService(RecruiterRepository recruiterRepository, RecruiterMapper recruiterMapper) {
        this.recruiterRepository = recruiterRepository;
        this.recruiterMapper = recruiterMapper;
    }

    public RecruiterDTO create(RecruiterDTO recruiterDTO) {
        Recruiter recruiter = recruiterMapper.toEntity(recruiterDTO);
        recruiter = recruiterRepository.save(recruiter);
        return recruiterMapper.toDto(recruiter);
    }

    public RecruiterDTO update(RecruiterDTO recruiterDTO) {
        Recruiter recruiter = recruiterRepository.findById(recruiterDTO.getId())
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));
        recruiterMapper.update(recruiter, recruiterDTO);
        recruiter = recruiterRepository.save(recruiter);
        return recruiterMapper.toDto(recruiter);
    }

    public RecruiterDTO partialUpdate(RecruiterDTO recruiterDTO) {
        Recruiter recruiter = recruiterRepository.findById(recruiterDTO.getId())
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));
        recruiterMapper.partialUpdate(recruiter, recruiterDTO);
        recruiter = recruiterRepository.save(recruiter);
        return recruiterMapper.toDto(recruiter);
    }

    public RecruiterDTO getById(Integer id) {
        Recruiter recruiter = recruiterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));
        return recruiterMapper.toDto(recruiter);
    }

    public void delete(Integer id) {
        recruiterRepository.deleteById(id);
    }

    public List<RecruiterDTO> getAll() {
        return recruiterRepository.findAll().stream()
                .map(recruiterMapper::toDto)
                .collect(Collectors.toList());
    }
}
