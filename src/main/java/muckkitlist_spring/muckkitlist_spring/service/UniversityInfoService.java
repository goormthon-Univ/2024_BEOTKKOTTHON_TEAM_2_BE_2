package muckkitlist_spring.muckkitlist_spring.service;

import muckkitlist_spring.muckkitlist_spring.entity.UniversityInfoEntity;
import muckkitlist_spring.muckkitlist_spring.repository.UniversityInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversityInfoService {
    @Autowired
    private UniversityInfoRepository universityInfoRepository;

    public UniversityInfoEntity findUniversityByName(String universityName) {
        return universityInfoRepository.findByUniversityName(universityName);
    }


}
