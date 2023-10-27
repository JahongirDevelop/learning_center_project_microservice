package uz.pdp.adminservice.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AdminEntity extends BaseEntity {
    private String name;
    private String phoneNumber;
    private String email;
    private UserRole role;

}
