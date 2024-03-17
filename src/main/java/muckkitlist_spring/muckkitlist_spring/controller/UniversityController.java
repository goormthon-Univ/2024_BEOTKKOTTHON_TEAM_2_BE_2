package muckkitlist_spring.muckkitlist_spring.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@Tag(name = "Response d", description = "Response Estimate API")

@RequestMapping("/api/universities")
public class UniversityController {

    @GetMapping("/{uniName}")
    public ResponseEntity<?> getUniversityByName(@PathVariable String uniName) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("University not found");
    }
    @GetMapping
    public ResponseEntity<?> getAllUniversities() {
        return ResponseEntity.ok("wow");
    }
}
