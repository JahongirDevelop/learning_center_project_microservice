package uz.pdp.studentservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class StudentEntity extends BaseEntity {
    @Column(unique = true)
    private UUID applicationId;
    private int rating; // baholash
    private String name;
    private String surname;
    private String password;
    private String phoneNumber;
    private String email;
    private UUID groupId;

}
