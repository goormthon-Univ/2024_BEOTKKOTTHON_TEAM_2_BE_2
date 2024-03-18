package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MemoDTO {
  private final String muckatlistId;
  private final String memoId;
  private final String restaurantId;

}
