package muckkitlist_spring.muckkitlist_spring.utility;

import muckkitlist_spring.muckkitlist_spring.dto.UserInfoDTO;
import muckkitlist_spring.muckkitlist_spring.entity.UserInfoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {
    @Mapping(source = "university", target = "university") // 매핑 방식 수정
    UserInfoDTO toDTO(UserInfoEntity entity);

    UserInfoEntity toEntity(UserInfoDTO userInfoDTO);
}
