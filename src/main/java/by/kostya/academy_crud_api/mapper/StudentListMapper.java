package by.kostya.academy_crud_api.mapper;


import by.kostya.academy_crud_api.database.entity.Student;
import by.kostya.academy_crud_api.dto.student.StudentReadDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = StudentMapper.class)
@Component
public interface StudentListMapper {
    List<StudentReadDto> studentListToListDto (List<Student> list);
}
