package uz.pdp.groupservice.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MentorResponse {
    private String name;
    private int experience;
    private Double salary;
    private String subject;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
