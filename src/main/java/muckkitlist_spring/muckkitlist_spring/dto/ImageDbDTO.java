package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ImageDbDTO {
  private String imageId;
  private java.sql.Date imageTimestamp;

}
