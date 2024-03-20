package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import muckkitlist_spring.muckkitlist_spring.entity.RestaurantInfoEntity;

@Data
@RequiredArgsConstructor
public class MemoDTO {
  private final String muckatlistId;
  private final RestaurantInfoDTO restaurant;
  private final boolean checks;
  private final boolean groups;


}
