package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ImagePersonalDTO {
  private final String imagePersonalId;
  private final String userId;
  private final String imageSrc;

}
