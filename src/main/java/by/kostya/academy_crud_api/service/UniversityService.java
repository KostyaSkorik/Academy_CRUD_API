package by.kostya.academy_crud_api.service;


import by.kostya.academy_crud_api.database.entity.University;
import by.kostya.academy_crud_api.database.repository.UniversityRepository;
import by.kostya.academy_crud_api.dto.UniversityDto;
import by.kostya.academy_crud_api.mapper.UniversityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityService {
    private final UniversityMapper universityMapper;
    private final UniversityRepository universityRepository;

    public List<UniversityDto> findAll(){
        List<University> universities = universityRepository.findAll();
        return universities.stream().map(universityMapper::toDto).toList();
    }
}
