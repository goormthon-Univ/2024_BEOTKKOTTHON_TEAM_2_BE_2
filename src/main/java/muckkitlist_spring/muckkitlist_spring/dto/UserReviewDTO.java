package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import muckkitlist_spring.muckkitlist_spring.entity.RestaurantInfoEntity;
import muckkitlist_spring.muckkitlist_spring.entity.UserInfoEntity;

import java.time.LocalDate;


@Data
@RequiredArgsConstructor
public class UserReviewDTO {
  private final String userReviewId;
  private final UserInfoDTO userInfo;
  private final RestaurantInfoDTO restaurant;
  private final double star;
  private final LocalDate writeTime;
  private final String details;
  private final int like_count;

}
  // 생성자, Getter 메서드는 롬복 라이브러리를 통해 자동으로 생성됨

