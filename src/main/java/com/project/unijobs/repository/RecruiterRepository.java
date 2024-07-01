package com.project.unijobs.repository;

import com.project.unijobs.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Integer> {
    Recruiter findByUserId(Integer userId);
}
