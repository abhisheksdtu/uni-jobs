package com.project.unijobs.dto;

import lombok.*;

import java.time.Instant;

@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Integer roleId;
    private Instant createdAt;
    private Instant updatedAt;
}
