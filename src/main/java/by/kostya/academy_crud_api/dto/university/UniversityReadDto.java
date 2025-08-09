package by.kostya.academy_crud_api.dto.university;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UniversityReadDto {
    private Long id;
    private String name;
}
