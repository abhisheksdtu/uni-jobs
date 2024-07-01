package com.project.unijobs.service;

import com.project.unijobs.dto.AdminDTO;
import com.project.unijobs.entity.Admin;
import com.project.unijobs.mapper.AdminMapper;
import com.project.unijobs.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    public AdminService(AdminRepository adminRepository,
                        AdminMapper adminMapper) {
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
    }

    public AdminDTO create(AdminDTO adminDTO) {
        Admin admin = adminMapper.toEntity(adminDTO);
        admin = adminRepository.save(admin);
        return adminMapper.toDto(admin);
    }

    public AdminDTO update(AdminDTO adminDTO) {
        Admin admin = adminRepository.findById(adminDTO.getId())
                .orElseThrow(() -> new RuntimeException("Admin not found"));
        adminMapper.update(admin, adminDTO);
        admin = adminRepository.save(admin);
        return adminMapper.toDto(admin);
    }

    public AdminDTO partialUpdate(AdminDTO adminDTO) {
        Admin admin = adminRepository.findById(adminDTO.getId())
                .orElseThrow(() -> new RuntimeException("Admin not found"));
        adminMapper.partialUpdate(admin, adminDTO);
        admin = adminRepository.save(admin);
        return adminMapper.toDto(admin);
    }

    public AdminDTO getById(Integer id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
        return adminMapper.toDto(admin);
    }

    public void delete(Integer id) {
        adminRepository.deleteById(id);
    }

    public List<AdminDTO> getAll() {
        return adminRepository.findAll().stream()
                .map(adminMapper::toDto)
                .collect(Collectors.toList());
    }
}
