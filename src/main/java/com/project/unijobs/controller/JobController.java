package com.project.unijobs.controller;

import com.project.unijobs.dto.JobDTO;
import com.project.unijobs.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public JobDTO create(@RequestBody JobDTO jobDTO) {
        return jobService.create(jobDTO);
    }

    @PutMapping("/{id}")
    public JobDTO update(@PathVariable Integer id,
                         @RequestBody JobDTO jobDTO) {
        jobDTO.setId(id);
        return jobService.update(jobDTO);
    }

    @PatchMapping("/{id}")
    public JobDTO partialUpdate(@PathVariable Integer id,
                                @RequestBody JobDTO jobDTO) {
        jobDTO.setId(id);
        return jobService.partialUpdate(jobDTO);
    }

    @GetMapping("/{id}")
    public JobDTO getById(@PathVariable Integer id) {
        return jobService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        jobService.delete(id);
    }

    @GetMapping
    public List<JobDTO> getAll() {
        return jobService.getAll();
    }

    @GetMapping("/search")
    public List<JobDTO> search(@RequestParam(required = false) String title,
                               @RequestParam(required = false) String location,
                               @RequestParam(required = false) String type) {
        return jobService.search(title, location, type);
    }
}
