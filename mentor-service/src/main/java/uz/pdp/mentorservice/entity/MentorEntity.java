package uz.pdp.mentorservice.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MentorEntity extends BaseEntity {
    private int experience;
    private Double salary;
    private String subject;
}
