package uz.pdp.adminservice.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApplicationEntity extends BaseEntity{
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private UUID courseId;

}
