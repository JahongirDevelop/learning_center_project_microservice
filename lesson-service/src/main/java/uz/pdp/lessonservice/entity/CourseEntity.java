package uz.pdp.lessonservice.entity;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseEntity extends BaseEntity {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
