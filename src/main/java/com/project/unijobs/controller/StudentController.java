package com.project.unijobs.controller;

import com.project.unijobs.dto.StudentDTO;
import com.project.unijobs.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentDTO create(@RequestBody StudentDTO studentDTO) {
        return studentService.create(studentDTO);
    }

    @PutMapping("/{id}")
    public StudentDTO update(@PathVariable Integer id,
                             @RequestBody StudentDTO studentDTO) {
        studentDTO.setId(id);
        return studentService.update(studentDTO);
    }

    @PatchMapping("/{id}")
    public StudentDTO partialUpdate(@PathVariable Integer id,
                                    @RequestBody StudentDTO studentDTO) {
        studentDTO.setId(id);
        return studentService.partialUpdate(studentDTO);
    }

    @GetMapping("/{id}")
    public StudentDTO getById(@PathVariable Integer id) {
        return studentService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        studentService.delete(id);
    }

    @GetMapping
    public List<StudentDTO> getAll() {
        return studentService.getAll();
    }
}
