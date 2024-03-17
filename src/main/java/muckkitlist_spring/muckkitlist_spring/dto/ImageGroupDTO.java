package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ImageGroupDTO {
  private String imageGroupId;
  private String groupMuckatId;
  private String imageSrc;

}
