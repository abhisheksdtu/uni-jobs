package com.project.unijobs.controller;

import com.project.unijobs.dto.UserDTO;
import com.project.unijobs.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDTO create(@RequestBody UserDTO userDTO) {
        return userService.create(userDTO);
    }

    @PatchMapping("/{id}")
    public UserDTO partialUpdate(@PathVariable Integer id,
                                 @RequestBody UserDTO userDTO) {
        return userService.partialUpdate(id, userDTO);
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return userService.getAll();
    }
}