package uz.pdp.lessonservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.lessonservice.entity.LessonStatus;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonCR {

    private UUID groupId;
    private Integer lessonNumber;
    private LessonStatus lessonStatus;

}
