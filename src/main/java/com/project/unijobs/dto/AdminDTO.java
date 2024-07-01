package com.project.unijobs.dto;

import lombok.*;

import java.time.Instant;

@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {
    private Integer id;
    private Integer userId;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private Instant createdAt;
    private Instant updatedAt;
}
