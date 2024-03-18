package muckkitlist_spring.muckkitlist_spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import muckkitlist_spring.muckkitlist_spring.entity.UniversityInfoEntity;
import muckkitlist_spring.muckkitlist_spring.service.UniversityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/universities")
@Tag(name = "University", description = "대학교 관련 API")
public class UniversityController {

    @Autowired
    private UniversityInfoService universityInfoService;

    @GetMapping("/university/{universityName}")
    public ResponseEntity<UniversityInfoEntity> getUniversityByName(@PathVariable String universityName) {
        UniversityInfoEntity university = universityInfoService.findUniversityByName(universityName);
        if (university != null) {
            return ResponseEntity.ok(university);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @Operation(summary = "모든 대학교 목록 조회", description = "모든 대학교 정보를 조회합니다.")
    public ResponseEntity<List<UniversityInfoEntity>> getAllUniversities() {
        List<UniversityInfoEntity> universities = universityInfoService.getAllUniversities();
        return ResponseEntity.ok(universities);
    }
}
