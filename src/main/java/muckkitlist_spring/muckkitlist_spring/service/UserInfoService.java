package muckkitlist_spring.muckkitlist_spring.service;

import muckkitlist_spring.muckkitlist_spring.dto.UserInfoDTO;
import muckkitlist_spring.muckkitlist_spring.entity.UserInfoEntity;
import muckkitlist_spring.muckkitlist_spring.repository.UniversityInfoRepository;
import muckkitlist_spring.muckkitlist_spring.repository.UserInfoRepository;
import muckkitlist_spring.muckkitlist_spring.utility.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserInfoService {

    private final UserInfoMapper userInfoMapper;
    private final UserInfoRepository userInfoRepository;
    private final UniversityInfoRepository universityInfoRepository;
    @Autowired
    public UserInfoService(UserInfoMapper userInfoMapper, UserInfoRepository userInfoRepository, UniversityInfoRepository universityInfoRepository) {
        this.userInfoMapper = userInfoMapper;
        this.userInfoRepository = userInfoRepository;
        this.universityInfoRepository = universityInfoRepository;
    }

    public List<UserInfoDTO> getAllUsers() {
        List<UserInfoEntity> userEntities = userInfoRepository.findAll();
        return userEntities.stream()
                .map(userInfoMapper::toDTO)
                .collect(Collectors.toList());
    }
    public UserInfoDTO getUserById(String userId) {
        Optional<UserInfoEntity> userEntityOptional = userInfoRepository.findById(userId);
        return userEntityOptional.map(userInfoMapper::toDTO).orElse(null);
    }


    public UserInfoDTO createUser(UserInfoDTO userInfoDTO,String setUniversity) {
        UserInfoEntity userInfoEntity = userInfoMapper.toEntity(userInfoDTO);

        userInfoEntity.setUniversityEntity(universityInfoRepository.findByUniversityName(setUniversity));

        UserInfoEntity savedEntity = userInfoRepository.save(userInfoEntity);
        return userInfoMapper.toDTO(savedEntity);
    }

    public UserInfoDTO updateUser(String userId, String changeUniversity,UserInfoDTO userInfoDTO) {
        Optional<UserInfoEntity> userEntityOptional = userInfoRepository.findById(userId);
        if (userEntityOptional.isPresent()) {
            UserInfoEntity userInfoEntity = userEntityOptional.get();
            userInfoEntity.setUniversityEntity(universityInfoRepository.findByUniversityName(changeUniversity)
            );
            UserInfoEntity updatedEntity = userInfoRepository.save(userInfoEntity);
            return userInfoMapper.toDTO(updatedEntity);
        } else {
            return null; // 사용자가 존재하지 않을 경우 예외처리 혹은 적절한 응답 반환
        }
    }

    public void deleteUser(String userId) {
        userInfoRepository.deleteById(userId);
    }
}
