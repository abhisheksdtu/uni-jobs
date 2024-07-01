package com.project.unijobs.controller;

import com.project.unijobs.dto.UserProfileDTO;
import com.project.unijobs.service.ProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public UserProfileDTO getProfile(@RequestParam Integer userId) {
        return profileService.getProfile(userId);
    }

    @PutMapping
    public UserProfileDTO updateProfile(@RequestBody UserProfileDTO userProfileDTO) {
        return profileService.updateProfile(userProfileDTO);
    }
}
