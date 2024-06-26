package com.project.unijobs.repository;

import com.project.unijobs.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    List<Job> findByJobTitleContainingAndLocationContainingAndJobTypeContaining(String title, String location, String jobType);
}
