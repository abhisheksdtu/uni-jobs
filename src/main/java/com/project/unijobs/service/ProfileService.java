package com.project.unijobs.service;

import com.project.unijobs.dto.UserProfileDTO;
import com.project.unijobs.entity.Admin;
import com.project.unijobs.entity.Recruiter;
import com.project.unijobs.entity.Student;
import com.project.unijobs.entity.User;
import com.project.unijobs.repository.AdminRepository;
import com.project.unijobs.repository.RecruiterRepository;
import com.project.unijobs.repository.StudentRepository;
import com.project.unijobs.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final RecruiterRepository recruiterRepository;
    private final AdminRepository adminRepository;

    public ProfileService(UserRepository userRepository,
                          StudentRepository studentRepository,
                          RecruiterRepository recruiterRepository,
                          AdminRepository adminRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.recruiterRepository = recruiterRepository;
        this.adminRepository = adminRepository;
    }

    public UserProfileDTO getProfile(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        UserProfileDTO.UserProfileDTOBuilder profileBuilder = UserProfileDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(getRole(user.getRoleId()));

        switch (user.getRoleId()) {
            case 1: // Assuming 1 is for Student
                Student student = studentRepository.findByUserId(userId);
                if (student != null) {
                    profileBuilder
                            .firstName(student.getFirstName())
                            .lastName(student.getLastName())
                            .dob(student.getDob())
                            .resumePath(student.getResumePath())
                            .profilePicture(student.getProfilePicture());
                }
                break;
            case 2: // Assuming 2 is for Recruiter
                Recruiter recruiter = recruiterRepository.findByUserId(userId);
                if (recruiter != null) {
                    profileBuilder
                            .companyName(recruiter.getCompanyName())
                            .companyLogo(recruiter.getCompanyLogo())
                            .contactNumber(recruiter.getContactNumber());
                }
                break;
            case 3: // Assuming 3 is for Admin
                Admin admin = adminRepository.findByUserId(userId);
                if (admin != null) {
                    profileBuilder
                            .firstName(admin.getFirstName())
                            .lastName(admin.getLastName())
                            .contactNumber(admin.getContactNumber());
                }
                break;
        }

        return profileBuilder.build();
    }

    public UserProfileDTO updateProfile(UserProfileDTO userProfileDTO) {
        User user = userRepository.findById(userProfileDTO.getId()).orElse(null);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        user.setUsername(userProfileDTO.getUsername());
        user.setEmail(userProfileDTO.getEmail());
        userRepository.save(user);

        switch (user.getRoleId()) {
            case 1: // Assuming 1 is for Student
                Student student = studentRepository.findByUserId(user.getId());
                if (student != null) {
                    student.setFirstName(userProfileDTO.getFirstName());
                    student.setLastName(userProfileDTO.getLastName());
                    student.setDob(userProfileDTO.getDob());
                    student.setResumePath(userProfileDTO.getResumePath());
                    student.setProfilePicture(userProfileDTO.getProfilePicture());
                    studentRepository.save(student);
                }
                break;
            case 2: // Assuming 2 is for Recruiter
                Recruiter recruiter = recruiterRepository.findByUserId(user.getId());
                if (recruiter != null) {
                    recruiter.setCompanyName(userProfileDTO.getCompanyName());
                    recruiter.setCompanyLogo(userProfileDTO.getCompanyLogo());
                    recruiter.setContactNumber(userProfileDTO.getContactNumber());
                    recruiterRepository.save(recruiter);
                }
                break;
            case 3: // Assuming 3 is for Admin
                Admin admin = adminRepository.findByUserId(user.getId());
                if (admin != null) {
                    admin.setFirstName(userProfileDTO.getFirstName());
                    admin.setLastName(userProfileDTO.getLastName());
                    admin.setContactNumber(userProfileDTO.getContactNumber());
                    adminRepository.save(admin);
                }
                break;
        }

        return userProfileDTO;
    }

    private String getRole(Integer roleId) {
        switch (roleId) {
            case 1:
                return "Student";
            case 2:
                return "Recruiter";
            case 3:
                return "Admin";
            default:
                throw new IllegalArgumentException("Invalid role ID");
        }
    }
}
