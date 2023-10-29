package uz.pdp.lessonservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.lessonservice.entity.GroupEntity;
import uz.pdp.lessonservice.entity.LessonStatus;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonResponse {
    private GroupEntity group;
    private Integer lessonNumber;
    private LessonStatus lessonStatus;
    private LocalDateTime createdDate;
    private LocalDateTime update;
}
