package uz.pdp.studentservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.UUID;
//@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentCR {
    @NotBlank(message = "must not empty")
    private UUID applicationId;
    @NotNull(message = "must not null")
    private int rating; // baholash
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private UUID groupId;
}
