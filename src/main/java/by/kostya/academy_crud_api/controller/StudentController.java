package by.kostya.academy_crud_api.controller;


import by.kostya.academy_crud_api.dto.student.StudentReadDto;
import by.kostya.academy_crud_api.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping
    public ResponseEntity<List<StudentReadDto>> findAll(Pageable pageable){
        return ResponseEntity.ok(studentService.findAllStudents(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentReadDto> findById(@PathVariable Long id){
        return studentService.findById(id).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
}
