package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GroupMuckatListDTO {
  private String groupmuckatId;
  private String userId;
  private String groupName;
  private boolean roomMaster;


}
