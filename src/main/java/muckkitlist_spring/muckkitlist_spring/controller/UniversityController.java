package muckkitlist_spring.muckkitlist_spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import muckkitlist_spring.muckkitlist_spring.dto.UniversityInfoDTO;
import muckkitlist_spring.muckkitlist_spring.entity.UniversityInfoEntity;
import muckkitlist_spring.muckkitlist_spring.service.UniversityInfoService;
import muckkitlist_spring.muckkitlist_spring.utility.UniversityInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/universities")
@Tag(name = "University", description = "대학교 관련 API")
public class UniversityController {

    private final UniversityInfoService universityInfoService;
    private final UniversityInfoMapper universityInfoMapper;

    @Autowired
    public UniversityController(UniversityInfoService universityInfoService, UniversityInfoMapper universityInfoMapper) {
        this.universityInfoService = universityInfoService;
        this.universityInfoMapper = universityInfoMapper;
    }


    @GetMapping
    @Operation(summary = "모든 대학교 목록 조회", description = "모든 대학교 정보를 조회합니다.")
    public ResponseEntity<List<UniversityInfoDTO>> getAllUniversities() {
        List<UniversityInfoDTO> universityDTOs = universityInfoService.getAllUniversities();
        return ResponseEntity.ok(universityDTOs);
    }
}
