package com.project.unijobs.service;

import com.project.unijobs.dto.StudentDTO;
import com.project.unijobs.entity.Student;
import com.project.unijobs.mapper.StudentMapper;
import com.project.unijobs.repository.StudentRepository;
import com.project.unijobs.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, UserRepository userRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
        this.studentMapper = studentMapper;
    }

    public StudentDTO create(StudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        student = studentRepository.save(student);
        return studentMapper.toDto(student);
    }

    public StudentDTO update(StudentDTO studentDTO) {
        Student student = studentRepository.findById(studentDTO.getId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        studentMapper.update(student, studentDTO);
        student = studentRepository.save(student);
        return studentMapper.toDto(student);
    }

    public StudentDTO partialUpdate(StudentDTO studentDTO) {
        Student student = studentRepository.findById(studentDTO.getId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        studentMapper.partialUpdate(student, studentDTO);
        student = studentRepository.save(student);
        return studentMapper.toDto(student);
    }

    public StudentDTO getById(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return studentMapper.toDto(student);
    }

    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    public List<StudentDTO> getAll() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }
}
