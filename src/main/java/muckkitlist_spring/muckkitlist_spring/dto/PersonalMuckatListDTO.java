package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PersonalMuckatListDTO {
  private String personalMuckatId;
  private UserInfoDTO user;
  private String personalName;

}
