package muckkitlist_spring.muckkitlist_spring.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import muckkitlist_spring.muckkitlist_spring.entity.UniversityInfoEntity;
import muckkitlist_spring.muckkitlist_spring.repository.UniversityInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class UniversityInfoService {
    @Autowired
    private UniversityInfoRepository universityInfoRepository;

    public UniversityInfoEntity findUniversityByName(String universityName) {
        return universityInfoRepository.findByUniversityName(universityName);
    }

    public List<UniversityInfoEntity> getAllUniversities() {
        return universityInfoRepository.findAll();
    }
}

