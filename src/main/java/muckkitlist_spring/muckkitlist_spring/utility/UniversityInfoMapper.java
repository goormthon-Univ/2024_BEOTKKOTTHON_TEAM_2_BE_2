package muckkitlist_spring.muckkitlist_spring.utility;

import muckkitlist_spring.muckkitlist_spring.dto.UniversityInfoDTO;
import muckkitlist_spring.muckkitlist_spring.entity.UniversityInfoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UniversityInfoMapper {
    UniversityInfoDTO toDto(UniversityInfoEntity entity);
    UniversityInfoEntity toEntity(UniversityInfoDTO dto);
}