package com.project.unijobs.repository;

import com.project.unijobs.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    List<Application> findByStudentId(Integer studentId);

    List<Application> findByJobId(Integer jobId);
}
