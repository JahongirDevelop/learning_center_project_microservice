package uz.pdp.groupservice.dto.request;

import lombok.*;
import uz.pdp.groupservice.entity.GroupStatus;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UpdateGroupDto {

    private String groupName;
    private UUID cursId;
    private UUID mentorId;
    private Integer studentCount;
    private GroupStatus status;
}
