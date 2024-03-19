package muckkitlist_spring.muckkitlist_spring.utility;

import muckkitlist_spring.muckkitlist_spring.dto.UniversityInfoDTO;
import muckkitlist_spring.muckkitlist_spring.dto.UserReviewDTO;
import muckkitlist_spring.muckkitlist_spring.entity.UniversityInfoEntity;
import muckkitlist_spring.muckkitlist_spring.entity.UserReviewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserReviewMapper {
    @Mapping(source = "userInfo", target = "userInfo") // 매핑 방식 수정
    @Mapping(source = "restaurant", target = "restaurant") // 매핑 방식 수정

    UserReviewDTO toDto(UserReviewEntity entity);
    UserReviewEntity toEntity(UserReviewDTO dto);
}