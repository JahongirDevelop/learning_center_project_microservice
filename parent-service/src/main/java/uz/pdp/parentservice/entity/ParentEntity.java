package uz.pdp.parentservice.entity;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ParentEntity extends BaseEntity {
    private UUID childId;

}
