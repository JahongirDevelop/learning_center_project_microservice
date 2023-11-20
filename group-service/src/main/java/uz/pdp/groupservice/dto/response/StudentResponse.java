package uz.pdp.groupservice.dto.response;

import lombok.*;


import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentResponse {
    private UUID userId;
    private int rating; // baholash
    private String name;
    private String surName;
    private String phoneNumber;
    private String email;
    private UserRole role;
}
