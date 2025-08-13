package by.kostya.academy_crud_api.dto.student;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateDto {

    @NotBlank
    @Length(max = 50)
    private String firstName;

    @NotBlank
    @Length(max = 50)
    private String lastName;

    private String universityName;
}
