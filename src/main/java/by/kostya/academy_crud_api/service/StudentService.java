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
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public StudentReadDto update(Long id,StudentCreateDto studentCreateDto){
        Student student = studentRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        if(studentCreateDto.getUniversityName()!=null){
            University university = universityRepository.findUniversityByName(studentCreateDto.getUniversityName())
                    .orElseThrow(IllegalArgumentException::new);
            student.setUniversity(university);
        }
        if(studentCreateDto.getFirstName()!=null){
            student.setFirstName(studentCreateDto.getFirstName());
        }
        if(studentCreateDto.getLastName()!=null){
            student.setLastName(studentCreateDto.getLastName());
        }
        return studentMapper.studentToDtoWithUni(studentRepository.save(student));


    }
}
