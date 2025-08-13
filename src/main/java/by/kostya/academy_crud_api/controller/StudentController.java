package by.kostya.academy_crud_api.controller;


import by.kostya.academy_crud_api.dto.student.StudentCreateDto;
import by.kostya.academy_crud_api.dto.student.StudentReadDto;
import by.kostya.academy_crud_api.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<StudentReadDto> create(@RequestBody @Valid StudentCreateDto studentCreateDto){
        try {
            return ResponseEntity.of(studentService.create(studentCreateDto));
        }catch (IllegalArgumentException e){
           return ResponseEntity.badRequest().header("error", "University not found").build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<StudentReadDto> update(@PathVariable Long id, @RequestBody @Valid StudentCreateDto studentCreateDto){
        try {
            return ResponseEntity.ok(studentService.update(id,studentCreateDto));
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().header("error", "University not found").build();
        }
    }

}
