package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ImagePersonalDTO {
  private String imagePersonalId;
  private String userId;
  private String imageSrc;

}
