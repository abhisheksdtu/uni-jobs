package com.project.unijobs.dto;

import lombok.*;

import java.time.Instant;

@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDTO {
    private Integer id;
    private String username;
    private String email;
    private String role;
    private String firstName;
    private String lastName;
    private Instant dob;
    private String resumePath;
    private String profilePicture;
    private String companyName;
    private String companyLogo;
    private String contactNumber;
}
