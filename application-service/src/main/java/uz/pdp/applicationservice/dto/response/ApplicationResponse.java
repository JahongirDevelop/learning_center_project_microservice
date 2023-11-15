package uz.pdp.applicationservice.dto.response;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ApplicationResponse {
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private UUID courseId;

}
