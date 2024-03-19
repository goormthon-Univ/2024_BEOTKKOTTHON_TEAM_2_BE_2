package muckkitlist_spring.muckkitlist_spring.utility;

import muckkitlist_spring.muckkitlist_spring.dto.UniversityInfoDTO;
import muckkitlist_spring.muckkitlist_spring.dto.UserReviewDTO;
import muckkitlist_spring.muckkitlist_spring.entity.UniversityInfoEntity;
import muckkitlist_spring.muckkitlist_spring.entity.UserReviewEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserReviewMapper {
    UserReviewDTO toDto(UserReviewEntity entity);
    UserReviewEntity toEntity(UserReviewDTO dto);
}