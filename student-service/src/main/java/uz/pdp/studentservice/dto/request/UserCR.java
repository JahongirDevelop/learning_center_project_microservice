package uz.pdp.studentservice.dto.request;

import lombok.*;
import uz.pdp.studentservice.entity.UserRole;


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
