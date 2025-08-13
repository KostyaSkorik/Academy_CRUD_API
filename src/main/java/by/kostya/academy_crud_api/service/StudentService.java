package by.kostya.academy_crud_api.service;

import by.kostya.academy_crud_api.database.entity.Student;
import by.kostya.academy_crud_api.database.entity.University;
import by.kostya.academy_crud_api.database.repository.StudentRepository;
import by.kostya.academy_crud_api.database.repository.UniversityRepository;
import by.kostya.academy_crud_api.dto.student.StudentCreateDto;
import by.kostya.academy_crud_api.dto.student.StudentReadDto;
import by.kostya.academy_crud_api.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;
    private final UniversityRepository universityRepository;


    public List<StudentReadDto> findAllStudents(Pageable pageable){
        return studentRepository.findAll(pageable).get().map(studentMapper::studentToDtoWithUni).toList();
    }

    public Optional<StudentReadDto> findById(Long id) {
        return studentRepository.findById(id).map(studentMapper::studentToDtoWithUni);
    }

    public Optional<StudentReadDto> create(StudentCreateDto studentCreateDto) throws IllegalArgumentException {
        University university = universityRepository.findUniversityByName(studentCreateDto.getUniversityName())
                .orElseThrow(IllegalArgumentException::new);
        return Optional.of(studentCreateDto)
                .map((dto)->{
                    Student student = studentMapper.studentCreatDtoToStudent(dto);
                    student.setUniversity(university);
                    return student;
                })
                .map(studentRepository::save)
                .map(studentMapper::studentToDtoWithUni);

    }
}
