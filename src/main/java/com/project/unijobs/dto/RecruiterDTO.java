package com.project.unijobs.dto;

import lombok.*;

import java.time.Instant;

@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecruiterDTO {
    private Integer id;
    private Integer userId;
    private String companyName;
    private String companyLogo;
    private String contactNumber;
    private Instant createdAt;
    private Instant updatedAt;
}
