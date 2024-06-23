package com.project.unijobs.dto;

import lombok.*;

@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String role;
}
