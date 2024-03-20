package muckkitlist_spring.muckkitlist_spring.utility;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import muckkitlist_spring.muckkitlist_spring.dto.MemoDTO;
import muckkitlist_spring.muckkitlist_spring.dto.UserInfoDTO;
import muckkitlist_spring.muckkitlist_spring.entity.MemoEntity;
import muckkitlist_spring.muckkitlist_spring.entity.UserInfoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface MemoMapper {

    MemoDTO toDTO(MemoEntity memoEntity);

    MemoEntity toEntity(MemoDTO memoDTO);
}
