package uz.pdp.userservice.dto.request;

import lombok.*;
import uz.pdp.userservice.entity.UserRole;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserCR {
    private String name;
    private String surName;
    private String phoneNumber;
    private String email;
    private String password;
    private UserRole role;
}
