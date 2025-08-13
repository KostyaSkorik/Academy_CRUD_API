package by.kostya.academy_crud_api.mapper;


import by.kostya.academy_crud_api.database.entity.Student;
import by.kostya.academy_crud_api.dto.student.StudentCreateDto;
import by.kostya.academy_crud_api.dto.student.StudentReadDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface StudentMapper {
    @Mapping(target = "university", ignore = true)
    @Named(value = "withoutUniversity")
    StudentReadDto studentToDto(Student student);

    StudentReadDto studentToDtoWithUni(Student student);

    @Mapping(target = "id", ignore = true)
    Student studentCreatDtoToStudent(StudentCreateDto student);
}
