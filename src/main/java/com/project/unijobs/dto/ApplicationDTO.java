package com.project.unijobs.dto;

import lombok.*;

import java.time.Instant;

@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDTO {
    private Integer id;
    private Integer studentId;
    private Integer jobId;
    private String applicationStatus;
    private Instant appliedAt;
    private Instant createdAt;
    private Instant updatedAt;
}
