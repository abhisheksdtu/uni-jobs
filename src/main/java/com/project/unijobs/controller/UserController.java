package com.project.unijobs.controller;

import com.project.unijobs.dto.UserDTO;
import com.project.unijobs.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("create")
    public UserDTO create(@RequestBody UserDTO userDTO) {
        return userService.create(userDTO);
    }

    @PatchMapping("update")
    public UserDTO update(@RequestBody UserDTO userDTO) {
        return userService.update(userDTO);
    }
}
