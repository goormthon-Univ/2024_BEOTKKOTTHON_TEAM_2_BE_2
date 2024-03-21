package muckkitlist_spring.muckkitlist_spring.service;

import muckkitlist_spring.muckkitlist_spring.dto.UserInfoClientDTO;
import muckkitlist_spring.muckkitlist_spring.dto.UserInfoDTO;
import muckkitlist_spring.muckkitlist_spring.entity.UniversityInfoEntity;
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


    public UserInfoClientDTO createUser(UserInfoClientDTO userInfoClientDTO) {
        UniversityInfoEntity universityInfoEntity = universityInfoRepository.findByUniversityName(userInfoClientDTO.getUniversityName());
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setKakaoId(userInfoClientDTO.getKakaoId());
        userInfoEntity.setUniversity(universityInfoEntity);
        userInfoEntity.setUserId(userInfoClientDTO.getUserId());
        userInfoEntity.setPoint(0);
        userInfoEntity.setFcmToken(userInfoClientDTO.getFcmToken());

        UserInfoEntity savedEntity = userInfoRepository.save(userInfoEntity);

        return new UserInfoClientDTO(savedEntity.getKakaoId(), savedEntity.getUserId(),
                savedEntity.getUniversity().getUniversityName(),
                savedEntity.getPoint(), savedEntity.getFcmToken());
    }

    public UserInfoClientDTO updateUserUniversity(UserInfoClientDTO userInfoClientDTO) {

        Optional<UserInfoEntity> userInfoEntity = userInfoRepository.findById(userInfoClientDTO.getKakaoId());
        if(userInfoEntity.isPresent()){
            UniversityInfoEntity universityInfoEntity = universityInfoRepository.findByUniversityName(userInfoClientDTO.getUniversityName());
            UserInfoEntity userInfoEntity1=userInfoEntity.get();
            userInfoEntity1.setUniversityEntity(universityInfoEntity);
            UserInfoEntity updatedEntity = userInfoRepository.save(userInfoEntity1);
            return
                    new UserInfoClientDTO(updatedEntity.getKakaoId(), updatedEntity.getUserId(),
                            updatedEntity.getUniversity().getUniversityName(),
                            updatedEntity.getPoint(), updatedEntity.getFcmToken());
        }
        return null;
        }


/*

    public UserInfoDTO updateUserName(UserInfoDTO userInfoDTO, String userName) {
        Optional<UserInfoEntity> userEntityOptional = userInfoRepository.findById(userInfoDTO.getUserId());
        if (userEntityOptional.isPresent()) {
            UserInfoEntity userInfoEntity = userEntityOptional.get();
            userInfoEntity.setUserId(userName);
            UserInfoEntity updatedEntity = userInfoRepository.save(userInfoEntity);
            return userInfoMapper.toDTO(updatedEntity);

        } else {
            return null; // 사용자가 존재하지 않을 경우 예외처리 혹은 적절한 응답 반환
        }
    }

*/

    public void deleteUser(String userId) {
        userInfoRepository.deleteById(userId);
    }
}
