package by.kostya.academy_crud_api.service;


import by.kostya.academy_crud_api.database.entity.University;
import by.kostya.academy_crud_api.database.repository.UniversityRepository;
import by.kostya.academy_crud_api.dto.university.UniversityCreateDto;
import by.kostya.academy_crud_api.dto.university.UniversityReadDto;
import by.kostya.academy_crud_api.mapper.UniversityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UniversityService {
    private final UniversityMapper universityMapper;
    private final UniversityRepository universityRepository;

    public List<UniversityReadDto> findAll(Pageable pageable){
        Page<University> universityPage = universityRepository.findAll(pageable);
        return universityPage.get().map(universityMapper::fromUniToReadDto).toList();
    }

    public Optional<UniversityReadDto> findById(Long id){
        return universityRepository.findById(id).map(universityMapper::fromUniToReadDto);
    }

    public UniversityReadDto createUniversity(UniversityCreateDto universityCreateDto){
        University university = universityMapper.fromCreatDtoToUni(universityCreateDto);
        University universityCreated = universityRepository.save(university);
        return universityMapper.fromUniToReadDto(universityCreated);

    }
}
