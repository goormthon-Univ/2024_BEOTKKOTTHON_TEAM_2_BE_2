package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ImageGroupDTO {
  private final String imageGroupId;
  private final String groupMuckatId;
  private final String imageSrc;

}
