package muckkitlist_spring.muckkitlist_spring.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Response 5", description = "Response Estimate API")
@RequestMapping("/api/group-muckatlist")
public class GroupMuckatlistController {


    @GetMapping("/{userId}")
    public ResponseEntity<?> getGroupMuckatlistsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok("yap");
    }

    @GetMapping("/{groupMuckatId}")
    public ResponseEntity<?> getGroupMuckatlistById(@PathVariable Long groupMuckatId) {
            return ResponseEntity.ok("yes");
    }

    @PostMapping
    public ResponseEntity<?> createGroupMuckatlist(@RequestBody GroupMuckatlist groupMuckatlist) {
        return ResponseEntity.status(HttpStatus.CREATED).body("하잉");
    }

    @PatchMapping("/{groupMuckatId}")
    public ResponseEntity<?> updateGroupMuckatlist(@PathVariable Long groupMuckatId, @RequestBody GroupMuckatlist groupMuckatlist) {
            return ResponseEntity.ok("야후");
    }

    @DeleteMapping("/{groupMuckatId}")
    public ResponseEntity<?> deleteGroupMuckatlist(@PathVariable Long groupMuckatId) {
            return ResponseEntity.ok("Group Muckatlist deleted successfully");
    }
}