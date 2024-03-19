package muckkitlist_spring.muckkitlist_spring.utility;

import muckkitlist_spring.muckkitlist_spring.dto.RestaurantInfoDTO;
import muckkitlist_spring.muckkitlist_spring.dto.UniversityInfoDTO;
import muckkitlist_spring.muckkitlist_spring.dto.UserReviewDTO;
import muckkitlist_spring.muckkitlist_spring.entity.RestaurantInfoEntity;
import muckkitlist_spring.muckkitlist_spring.entity.UniversityInfoEntity;
import muckkitlist_spring.muckkitlist_spring.entity.UserReviewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserReviewMapper {
    @Mapping(source = "userInfo", target = "userInfo")
    @Mapping(source = "restaurant", target = "restaurant")
    UserReviewDTO toDto(UserReviewEntity entity);

    @Mapping(source = "userInfo", target = "userInfo")
    @Mapping(source = "restaurant", target = "restaurant")
    UserReviewEntity toEntity(UserReviewDTO dto);

    UniversityInfoEntity map(UniversityInfoDTO dto);

    RestaurantInfoEntity map(RestaurantInfoDTO dto);
}
