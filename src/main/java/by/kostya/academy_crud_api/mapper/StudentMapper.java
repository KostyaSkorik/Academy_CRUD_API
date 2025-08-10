package by.kostya.academy_crud_api.mapper;


import by.kostya.academy_crud_api.database.entity.Student;
import by.kostya.academy_crud_api.dto.student.StudentReadDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface StudentMapper {
    StudentReadDto studentToDto(Student student);
}
