package uz.pdp.attendanceservice.entity;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AttendanceEntity extends BaseEntity {
    private UUID lessonId;
    private UUID studentId;
    private String description; // sabab

}
