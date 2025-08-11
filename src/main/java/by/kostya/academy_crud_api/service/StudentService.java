package by.kostya.academy_crud_api.service;

import by.kostya.academy_crud_api.database.repository.StudentRepository;
import by.kostya.academy_crud_api.dto.student.StudentReadDto;
import by.kostya.academy_crud_api.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;


    public List<StudentReadDto> findAllStudents(Pageable pageable){
        return studentRepository.findAll(pageable).get().map(studentMapper::studentToDtoWithUni).toList();
    }
}
