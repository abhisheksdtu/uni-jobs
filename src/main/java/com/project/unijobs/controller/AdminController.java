package com.project.unijobs.controller;

import com.project.unijobs.dto.AdminDTO;
import com.project.unijobs.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public AdminDTO create(@RequestBody AdminDTO adminDTO) {
        return adminService.create(adminDTO);
    }

    @PutMapping("/{id}")
    public AdminDTO update(@PathVariable Integer id,
                           @RequestBody AdminDTO adminDTO) {
        adminDTO.setId(id);
        return adminService.update(adminDTO);
    }

    @PatchMapping("/{id}")
    public AdminDTO partialUpdate(@PathVariable Integer id,
                                  @RequestBody AdminDTO adminDTO) {
        adminDTO.setId(id);
        return adminService.partialUpdate(adminDTO);
    }

    @GetMapping("/{id}")
    public AdminDTO getById(@PathVariable Integer id) {
        return adminService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        adminService.delete(id);
    }

    @GetMapping
    public List<AdminDTO> getAll() {
        return adminService.getAll();
    }
}
