package uz.pdp.groupservice.dto.response;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseResponse {
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
