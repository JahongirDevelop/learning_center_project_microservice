package uz.pdp.groupservice.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LessonEntity extends BaseEntity{
    @ManyToOne(cascade = CascadeType.PERSIST) // or CascadeType.ALL
    private GroupEntity group;
    private Integer lessonNumber;
    private LessonStatus lessonStatus;
}
