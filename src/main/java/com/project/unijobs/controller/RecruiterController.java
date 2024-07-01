package com.project.unijobs.controller;

import com.project.unijobs.dto.RecruiterDTO;
import com.project.unijobs.service.RecruiterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {
    private final RecruiterService recruiterService;

    public RecruiterController(RecruiterService recruiterService) {
        this.recruiterService = recruiterService;
    }

    @PostMapping
    public RecruiterDTO create(@RequestBody RecruiterDTO recruiterDTO) {
        return recruiterService.create(recruiterDTO);
    }

    @PutMapping("/{id}")
    public RecruiterDTO update(@PathVariable Integer id,
                               @RequestBody RecruiterDTO recruiterDTO) {
        recruiterDTO.setId(id);
        return recruiterService.update(recruiterDTO);
    }

    @PatchMapping("/{id}")
    public RecruiterDTO partialUpdate(@PathVariable Integer id,
                                      @RequestBody RecruiterDTO recruiterDTO) {
        recruiterDTO.setId(id);
        return recruiterService.partialUpdate(recruiterDTO);
    }

    @GetMapping("/{id}")
    public RecruiterDTO getById(@PathVariable Integer id) {
        return recruiterService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        recruiterService.delete(id);
    }

    @GetMapping
    public List<RecruiterDTO> getAll() {
        return recruiterService.getAll();
    }
}
