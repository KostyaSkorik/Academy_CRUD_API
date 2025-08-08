package by.kostya.academy_crud_api.controller;


import by.kostya.academy_crud_api.dto.UniversityDto;
import by.kostya.academy_crud_api.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/universities")
@RequiredArgsConstructor
public class UniversityController {

    private final UniversityService universityService;

    @GetMapping
    public ResponseEntity<List<UniversityDto>> findAll(Pageable pageable) {
        List<UniversityDto> universityDtos = universityService.findAll(pageable);
        if(universityDtos.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(universityDtos);
        }
    }
}
