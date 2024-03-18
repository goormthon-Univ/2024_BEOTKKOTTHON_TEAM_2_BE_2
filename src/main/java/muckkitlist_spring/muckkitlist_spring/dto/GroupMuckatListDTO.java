package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GroupMuckatListDTO {
  private final String groupmuckatId;
  private final String userId;
  private final String groupName;
  private final boolean roomMaster;


}
