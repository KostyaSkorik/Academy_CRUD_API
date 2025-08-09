package by.kostya.academy_crud_api.controller;


import by.kostya.academy_crud_api.dto.university.UniversityCreateDto;
import by.kostya.academy_crud_api.dto.university.UniversityReadDto;
import by.kostya.academy_crud_api.service.UniversityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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


}
