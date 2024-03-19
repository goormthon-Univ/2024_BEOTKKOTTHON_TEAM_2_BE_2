package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import muckkitlist_spring.muckkitlist_spring.entity.UserInfoEntity;

@Data
@RequiredArgsConstructor
public class GroupMuckatListDTO {
  private final String groupmuckatId;
  private final UserInfoEntity user;
  private final String groupName;
  private final boolean roomMaster;


}
