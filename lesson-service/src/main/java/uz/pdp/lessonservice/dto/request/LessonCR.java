package uz.pdp.lessonservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.lessonservice.entity.GroupEntity;
import uz.pdp.lessonservice.entity.LessonStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonCR {

    private GroupEntity group;
    private Integer lessonNumber;
    private LessonStatus lessonStatus;

}
