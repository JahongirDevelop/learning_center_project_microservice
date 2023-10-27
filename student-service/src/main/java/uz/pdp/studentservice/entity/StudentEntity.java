package uz.pdp.studentservice.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentEntity extends BaseEntity {

    private String name;
    private String phoneNumber;
    private String email;
    private UserRole role;

}
