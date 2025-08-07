package by.kostya.academy_crud_api.mapper;


import by.kostya.academy_crud_api.database.entity.University;
import by.kostya.academy_crud_api.dto.UniversityDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface UniversityMapper {

    UniversityDto toDto(University university);
}
