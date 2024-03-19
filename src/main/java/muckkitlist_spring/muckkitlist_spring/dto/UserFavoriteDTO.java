package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import muckkitlist_spring.muckkitlist_spring.entity.RestaurantInfoEntity;

@Data
@RequiredArgsConstructor
public class UserFavoriteDTO {
  private final String userId;
  private final RestaurantInfoEntity restaurantInfoEntity;

  // 생성자, Getter 메서드는 롬복 라이브러리를 통해 자동으로 생성됨
}
