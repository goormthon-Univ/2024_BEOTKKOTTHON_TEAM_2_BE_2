package muckkitlist_spring.muckkitlist_spring.service;


import muckkitlist_spring.muckkitlist_spring.entity.UniversityInfoEntity;
import muckkitlist_spring.muckkitlist_spring.entity.UserInfoEntity;
import muckkitlist_spring.muckkitlist_spring.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService{
    private final UserInfoRepository userInfoRepository;

    @Autowired
    public UserInfoService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public List<UserInfoEntity> getAllUsers() {
        return userInfoRepository.findAll();
    }

    public Optional<UserInfoEntity> getUserById(String userId) {
        return userInfoRepository.findById(userId);
    }

    public UserInfoEntity createUser(UserInfoEntity userInfo) {
        return userInfoRepository.save(userInfo);
    }

    public UserInfoEntity updateUserUniversity(String userId, UniversityInfoEntity university) {
        UserInfoEntity user = userInfoRepository.findById(userId).orElse(null);
        if (user != null) {
            user.updateUniversityInfo(university);
            return userInfoRepository.save(user);
        }
        return null;
    }


    public void deleteUser(String userId) {
        userInfoRepository.deleteById(userId);
    }
}
