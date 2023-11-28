package uz.pdp.lessonservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.lessonservice.entity.LessonStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonResponse {
    private UUID groupId;
    private Integer lessonNumber;
    private LessonStatus lessonStatus;
    private LocalDateTime createdDate;

}
