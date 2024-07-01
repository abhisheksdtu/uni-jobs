package com.project.unijobs.controller;

import com.project.unijobs.dto.ApplicationDTO;
import com.project.unijobs.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ApplicationDTO create(@RequestBody ApplicationDTO applicationDTO) {
        return applicationService.create(applicationDTO);
    }

    @PutMapping("/{id}")
    public ApplicationDTO update(@PathVariable Integer id,
                                 @RequestBody ApplicationDTO applicationDTO) {
        applicationDTO.setId(id);
        return applicationService.update(applicationDTO);
    }

    @PatchMapping("/{id}")
    public ApplicationDTO partialUpdate(@PathVariable Integer id,
                                        @RequestBody ApplicationDTO applicationDTO) {
        applicationDTO.setId(id);
        return applicationService.partialUpdate(applicationDTO);
    }

    @GetMapping("/{id}")
    public ApplicationDTO getById(@PathVariable Integer id) {
        return applicationService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        applicationService.delete(id);
    }

    @GetMapping
    public List<ApplicationDTO> getAll() {
        return applicationService.getAll();
    }

    @GetMapping("/student/{studentId}")
    public List<ApplicationDTO> getByStudentId(@PathVariable Integer studentId) {
        return applicationService.getByStudentId(studentId);
    }

    @GetMapping("/job/{jobId}")
    public List<ApplicationDTO> getByJobId(@PathVariable Integer jobId) {
        return applicationService.getByJobId(jobId);
    }
}
