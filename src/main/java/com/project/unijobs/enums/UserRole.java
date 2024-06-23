package com.project.unijobs.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    ADMIN(1, "Admin"),
    RECRUITER(2, "Recruiter"),
    STUDENT(3, "Student");

    private final int id;
    private final String name;
}