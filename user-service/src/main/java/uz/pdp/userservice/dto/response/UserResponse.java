package uz.pdp.userservice.dto.response;

import lombok.*;
import uz.pdp.userservice.entity.UserRole;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserResponse {
    private String name;
    private String surName;
    private String phoneNumber;
    private String email;
    private UserRole role;
}
