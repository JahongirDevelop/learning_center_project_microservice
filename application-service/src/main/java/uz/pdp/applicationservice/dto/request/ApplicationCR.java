package uz.pdp.applicationservice.dto.request;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ApplicationCR {

    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private UUID groupId;
}
