package muckkitlist_spring.muckkitlist_spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import muckkitlist_spring.muckkitlist_spring.dto.UserInfoDTO;
import muckkitlist_spring.muckkitlist_spring.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User", description = "사용자 관련 API")
public class UserInfoController {

    private final UserInfoService userInfoService;

    @Autowired
    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping
    @Operation(summary = "모든 사용자 조회", description = "모든 사용자 정보를 조회합니다.")
    public ResponseEntity<List<UserInfoDTO>> getAllUsers() {
        List<UserInfoDTO> userDTOs = userInfoService.getAllUsers();
        return ResponseEntity.ok(userDTOs);
    }

    @GetMapping("/{userId}")
    @Operation(summary = "사용자 조회", description = "특정 사용자의 정보를 조회합니다.")
    public ResponseEntity<UserInfoDTO> getUserById(@PathVariable String userId) {
        UserInfoDTO userDTO = userInfoService.getUserById(userId);
        return userDTO != null ?
                ResponseEntity.ok(userDTO) :
                ResponseEntity.notFound().build();
    }

    @PostMapping("/{setUniversity}")
    @Operation(summary = "사용자 생성", description = "새로운 사용자를 생성합니다.")
    public ResponseEntity<UserInfoDTO> createUser(@RequestBody UserInfoDTO userInfoDTO,@PathVariable String setUniversity) {
        UserInfoDTO createdUserDTO = userInfoService.createUser(userInfoDTO,setUniversity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserDTO);
    }

    @PutMapping("/{userId}/{changeUniversity}")
    @Operation(summary = "사용자 정보 수정", description = "특정 사용자의 정보를 수정합니다.")
    public ResponseEntity<UserInfoDTO> updateUser(@PathVariable String userId,@PathVariable String changeUniversity, @RequestBody UserInfoDTO userInfoDTO) {
        UserInfoDTO updatedUserDTO = userInfoService.updateUser(userId, changeUniversity,userInfoDTO);
        return ResponseEntity.ok(updatedUserDTO);
    }

    @DeleteMapping("/{userId}")
    @Operation(summary = "사용자 삭제", description = "특정 사용자를 삭제합니다.")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        userInfoService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
