package uz.pdp.studentservice.dto.response;

import lombok.*;


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
    private GroupStatus status;
}
