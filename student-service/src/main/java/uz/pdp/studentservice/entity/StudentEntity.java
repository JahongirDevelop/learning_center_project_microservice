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

    private int rating; // baholash

}
