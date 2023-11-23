package uz.pdp.groupservice.dto.response;

import lombok.*;
import uz.pdp.groupservice.entity.GroupStatus;
import uz.pdp.groupservice.entity.LessonEntity;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GroupResponse {
    private String groupName;
    private Integer studentCount;
    private UUID courseId;
    private UUID mentorId;
    private List<LessonEntity> lessons;
    private GroupStatus status;
}
