package uz.pdp.studentservice.entity;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentEntity extends BaseEntity {
    private UUID userId;

    private int rating; // baholash

}
