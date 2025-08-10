package by.kostya.academy_crud_api.dto.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentReadDto {
    private Long id;
    private String firstName;
    private String lastName;
//    private Long universityId;
}
