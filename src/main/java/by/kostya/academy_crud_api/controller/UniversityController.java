package by.kostya.academy_crud_api.controller;


import by.kostya.academy_crud_api.dto.student.StudentReadDto;
import by.kostya.academy_crud_api.dto.university.UniversityCreateDto;
import by.kostya.academy_crud_api.dto.university.UniversityReadDto;
import by.kostya.academy_crud_api.service.UniversityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/universities")
@RequiredArgsConstructor
public class UniversityController {

    private final UniversityService universityService;

    @GetMapping
    public ResponseEntity<List<UniversityReadDto>> findAll(Pageable pageable) {
        List<UniversityReadDto> universityReadDtos = universityService.findAll(pageable);
        if(universityReadDtos.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(universityReadDtos);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniversityReadDto> findById(@PathVariable Long id){
        return ResponseEntity.of(universityService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UniversityReadDto> create(@Valid @RequestBody UniversityCreateDto university){
        UniversityReadDto universityReadDto = universityService.createUniversity(university);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(universityReadDto.getId())
                .toUri();
        return ResponseEntity.created(location).body(universityReadDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UniversityReadDto> update(@PathVariable Long id, @Valid @RequestBody UniversityCreateDto universityCreateDto){
        UniversityReadDto universityReadDto = universityService.updateUniversity(id,universityCreateDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(universityReadDto.getId())
                .toUri();
        return ResponseEntity.created(location).body(universityReadDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return universityService.deleteUniversity(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().header("error","University not found or have students").build();
    }

    @GetMapping("{id}/students")
    public ResponseEntity<List<StudentReadDto>> findStudentsByUniversityId(@PathVariable Long id){
        return universityService.findStudentsByUniversityId(id)==null ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(universityService.findStudentsByUniversityId(id));
    }



}
