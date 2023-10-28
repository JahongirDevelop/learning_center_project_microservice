package uz.pdp.lessonservice.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LessonEntity extends BaseEntity {
    private GroupEntity group;
    private Integer lessonNumber;
    private LessonStatus lessonStatus;
}
