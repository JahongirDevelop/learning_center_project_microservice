package uz.pdp.courseservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseCreateDTO{
   @NotBlank(message = "must not empty")
   private String name;

   @NotBlank(message = "must not empty")
   private String description;

}
