package uz.pdp.groupservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GroupCreateDTO {
    @NotBlank(message = "must not empty")
    private String groupName;

    @NotNull(message = "must not null")
    private UUID courseId;

    @NotNull(message = "must not null")
    private UUID mentorId;
}
