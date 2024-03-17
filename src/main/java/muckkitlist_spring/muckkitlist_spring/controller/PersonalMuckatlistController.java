package muckkitlist_spring.muckkitlist_spring.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Response 4", description = "Response Estimate API")

@RequestMapping("/api/personal-muckatlist")
public class PersonalMuckatlistController {

    @GetMapping("/{userId}")
    public ResponseEntity<?> getAllPersonalMuckatlistsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok("끼야호");
    }

    @GetMapping("/{personalMuckatId}")
    public ResponseEntity<?> getPersonalMuckatlistById(@PathVariable Long personalMuckatId) {
            return ResponseEntity.ok("헉");
    }

    @PostMapping
    public ResponseEntity<?> createPersonalMuckatlist(@RequestBody PersonalMuckatlist personalMuckatlist) {
        return ResponseEntity.status(HttpStatus.CREATED).body("하이");
    }

    @PatchMapping("/{personalMuckatId}")
    public ResponseEntity<?> updatePersonalMuckatlist(@PathVariable Long personalMuckatId, @RequestBody PersonalMuckatlist personalMuckatlist) {
            return ResponseEntity.ok("하이");
    }

    @DeleteMapping("/{personalMuckatId}")
    public ResponseEntity<?> deletePersonalMuckatlist(@PathVariable Long personalMuckatId) {
            return ResponseEntity.ok("Personal Muckatlist deleted successfully");
    }
}
