package uz.pdp.groupservice.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GroupEntity extends BaseEntity {
    private String groupName;

    @Max(value = 20, message = "20 tadan ko'p bola xonaga sig'maydi")
    @Min(value = 10, message = "10 ta bolaga dars o'tish qoplamaydi")
    private Integer studentCount;


    @ManyToOne(cascade = CascadeType.PERSIST) // or CascadeType.ALL
    private CourseEntity course;

    @ManyToOne(cascade = CascadeType.PERSIST) // or CascadeType.ALL
    private MentorEntity mentorEntity;

    @OneToMany
    private List<LessonEntity> lessons;

    private GroupStatus status;
}
