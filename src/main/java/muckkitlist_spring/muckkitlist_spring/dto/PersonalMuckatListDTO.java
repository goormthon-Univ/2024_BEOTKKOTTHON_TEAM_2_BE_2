package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PersonalMuckatListDTO {
  private final String personalMuckatId;
  private final String userId;
  private final String personalName;

}
