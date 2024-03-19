package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import muckkitlist_spring.muckkitlist_spring.entity.UserInfoEntity;

@Data
@RequiredArgsConstructor
public class PersonalMuckatListDTO {
  private final String personalMuckatId;
  private final UserInfoEntity user;
  private final String personalName;

}
