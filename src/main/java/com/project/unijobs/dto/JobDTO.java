package com.project.unijobs.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobDTO {
    private Integer id;
    private Integer recruiterId;
    private String jobTitle;
    private String jobDescription;
    private String location;
    private String jobType;
    private BigDecimal salary;
    private Instant postedAt;
    private Instant createdAt;
    private Instant updatedAt;
}
