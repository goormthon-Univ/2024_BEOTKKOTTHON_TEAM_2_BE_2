package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MemoDTO {
  private String muckatlistId;
  private String memoId;
  private RestaurantInfoDTO restaurant;

}
