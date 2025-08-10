package by.kostya.academy_crud_api.mapper;


import by.kostya.academy_crud_api.database.entity.University;
import by.kostya.academy_crud_api.dto.university.UniversityCreateDto;
import by.kostya.academy_crud_api.dto.university.UniversityReadDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,uses = StudentListMapper.class)
@Component
public interface UniversityMapper {

    UniversityReadDto fromUniToReadDto(University university);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "students", ignore = true)
    University fromCreatDtoToUni(UniversityCreateDto universityCreateDto);
    }
