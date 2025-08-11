package by.kostya.academy_crud_api.dto.student;

import by.kostya.academy_crud_api.database.entity.Course;
import by.kostya.academy_crud_api.database.entity.University;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentReadDto {
    private Long id;
    private String firstName;
    private String lastName;
    private List<Course> courses;
    private University university;
}
