package muckkitlist_spring.muckkitlist_spring.service;

import lombok.RequiredArgsConstructor;
import muckkitlist_spring.muckkitlist_spring.dto.UniversityInfoDTO;
import muckkitlist_spring.muckkitlist_spring.entity.UniversityInfoEntity;
import muckkitlist_spring.muckkitlist_spring.repository.UniversityInfoRepository;
import muckkitlist_spring.muckkitlist_spring.utility.UniversityInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UniversityInfoService {

    private final UniversityInfoRepository universityInfoRepository;
    private final UniversityInfoMapper universityInfoMapper;

    public UniversityInfoDTO getUniversityByName(String universityName) {
        UniversityInfoEntity universityEntity = universityInfoRepository.findByUniversityName(universityName);
        return universityInfoMapper.toDto(universityEntity);
    }

    public List<UniversityInfoDTO> getAllUniversities() {
        List<UniversityInfoEntity> universityEntities = universityInfoRepository.findAll();
        return universityEntities.stream()
                .map(universityInfoMapper::toDto)
                .collect(Collectors.toList());
    }
}
