package com.project.unijobs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.project.unijobs")
public class UniJobsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniJobsApplication.class, args);
    }

}
