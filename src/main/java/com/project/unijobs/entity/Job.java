package com.project.unijobs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jobs")
public class Job extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "recruiter_id", nullable = false)
    private Recruiter recruiter;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "job_description", nullable = false)
    private String jobDescription;

    @Column(name = "location")
    private String location;

    @Column(name = "job_type")
    private String jobType;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "posted_at")
    private Instant postedAt;
}
