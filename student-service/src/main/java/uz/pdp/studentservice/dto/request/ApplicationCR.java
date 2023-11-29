package uz.pdp.studentservice.dto.request;

import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ApplicationCR {
    private UUID applicationId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String password;
    private UUID groupId;

}
