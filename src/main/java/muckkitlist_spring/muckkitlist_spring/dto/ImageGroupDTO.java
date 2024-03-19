package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import muckkitlist_spring.muckkitlist_spring.entity.GroupMuckatListEntity;

@Data
@RequiredArgsConstructor
public class ImageGroupDTO {
  private final String imageGroupId;
  private final GroupMuckatListEntity groupMuckatListEntity;
  private final String imageSrc;

}
