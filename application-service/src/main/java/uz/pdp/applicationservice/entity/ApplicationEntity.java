package uz.pdp.applicationservice.entity;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ApplicationEntity extends BaseEntity{
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private UUID courseId;

}
