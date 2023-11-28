package uz.pdp.lessonservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LessonEntity extends BaseEntity {
    private UUID groupId;
    private Integer lessonNumber;
    @Enumerated(EnumType.STRING)
    private LessonStatus lessonStatus;
}
