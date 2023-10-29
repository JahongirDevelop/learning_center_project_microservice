package uz.pdp.mentorservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MentorResponse {

    private int experience;
    private Double salary;
    private String subject;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
