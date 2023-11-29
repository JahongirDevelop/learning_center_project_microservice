package uz.pdp.studentservice.dto.response;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentResponse {
    private UUID applicationId;
    private int rating; // baholash
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private UUID groupId;

}
