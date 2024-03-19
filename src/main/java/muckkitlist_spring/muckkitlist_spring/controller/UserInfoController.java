package muckkitlist_spring.muckkitlist_spring.controller;

import muckkitlist_spring.muckkitlist_spring.dto.UserInfoDTO;
import muckkitlist_spring.muckkitlist_spring.entity.UniversityInfoEntity;
import muckkitlist_spring.muckkitlist_spring.entity.UserInfoEntity;
import muckkitlist_spring.muckkitlist_spring.service.UniversityInfoService;
import muckkitlist_spring.muckkitlist_spring.service.UserInfoService;
import muckkitlist_spring.muckkitlist_spring.utility.UniversityInfoMapper;
import muckkitlist_spring.muckkitlist_spring.utility.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserInfoController {

    private final UniversityInfoService universityInfoService;
    private final UserInfoService userInfoService;
    private final UserInfoMapper userInfoMapper;

    private final UniversityInfoMapper universityInfoMapper;
    @Autowired
    public UserInfoController(UniversityInfoService universityInfoService, UserInfoService userInfoService, UserInfoMapper userInfoMapper, UniversityInfoMapper universityInfoMapper) {
        this.universityInfoService = universityInfoService;
        this.userInfoService = userInfoService;
        this.userInfoMapper = userInfoMapper;
        this.universityInfoMapper=universityInfoMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserInfoDTO>> getAllUsers() {
        List<UserInfoEntity> users = userInfoService.getAllUsers();
        List<UserInfoDTO> userDTOs = users.stream()
                .map(userInfoMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDTOs);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserInfoDTO> getUserById(@PathVariable String userId) {
        return userInfoService.getUserById(userId)
                .map(userEntity -> ResponseEntity.ok(userInfoMapper.toDTO(userEntity)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserInfoDTO> createUser(@RequestBody UserInfoDTO userInfoDTO) {
        UserInfoEntity userEntity = userInfoMapper.toEntity(userInfoDTO);
        UniversityInfoEntity universityInfoEntity=universityInfoService.findUniversityByName(String.valueOf(userInfoDTO.getUniversity().getUniversityName()));
        userEntity.setUniversityEntity(universityInfoEntity);
        UserInfoEntity savedUserEntity = userInfoService.createUser(userEntity);
        UserInfoDTO savedUserDTO = userInfoMapper.toDTO(savedUserEntity);
        return new ResponseEntity<>(savedUserDTO, HttpStatus.CREATED);
    }

    //유저의 대학 정보를 변경
    @PutMapping("/{userId}/{updateUniversity}")
    public ResponseEntity<UserInfoDTO> updateUser(@PathVariable String userId,@PathVariable String updateUniversity, @RequestBody UserInfoDTO userInfoDTO) {
        UserInfoEntity userEntity = userInfoMapper.toEntity(userInfoDTO);
        UniversityInfoEntity universityInfoEntity;
        universityInfoEntity=universityInfoService.findUniversityByName(updateUniversity);
        UserInfoEntity updatedUserEntity = userInfoService.updateUserUniversity(userId, universityInfoEntity);
        UserInfoDTO updatedUserDTO = userInfoMapper.toDTO(updatedUserEntity);
        return ResponseEntity.ok(updatedUserDTO);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        userInfoService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}


