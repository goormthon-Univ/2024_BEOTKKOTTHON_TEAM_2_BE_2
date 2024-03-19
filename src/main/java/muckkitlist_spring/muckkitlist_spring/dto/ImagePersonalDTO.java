package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import muckkitlist_spring.muckkitlist_spring.entity.UserInfoEntity;

@Data
@RequiredArgsConstructor
public class ImagePersonalDTO {
  private final String imagePersonalId;
  private final UserInfoEntity userInfoEntity;
  private final String imageSrc;

}
