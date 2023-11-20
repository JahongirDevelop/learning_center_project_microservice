package uz.pdp.groupservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;
//@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentCR {
    @NotBlank(message = "must not empty")
    private UUID userId;
    @NotNull(message = "must not null")
    private int rating; // baholash
}