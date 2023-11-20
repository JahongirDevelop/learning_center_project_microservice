package uz.pdp.groupservice.dto.response;

import lombok.*;
import uz.pdp.groupservice.entity.CourseEntity;
import uz.pdp.groupservice.entity.GroupStatus;
import uz.pdp.groupservice.entity.LessonEntity;
import uz.pdp.groupservice.entity.MentorEntity;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GroupResponse {
    private String groupName;
    private Integer studentCount;
    private CourseEntity course;
    private MentorEntity mentorEntity;
    private List<LessonEntity> lessons;
    private GroupStatus status;
}
