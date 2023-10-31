package uz.pdp.studentservice.dto.response;

import lombok.*;
import uz.pdp.studentservice.entity.UserRole;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserResponse {
    private String name;
    private String surName;
    private String phoneNumber;
    private String email;
    private String password;
    private UserRole role;
}
