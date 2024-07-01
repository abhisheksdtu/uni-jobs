package com.project.unijobs.dto;

import lombok.*;

import java.time.Instant;

@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Integer id;
    private Integer userId;
    private String firstName;
    private String lastName;
    private Instant dob;
    private String resumePath;
    private String profilePicture;
    private Instant createdAt;
    private Instant updatedAt;
}
