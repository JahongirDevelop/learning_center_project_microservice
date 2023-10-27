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

    private String name;
    private String phoneNumber;
    private String email;
    private UserRole role;

}
