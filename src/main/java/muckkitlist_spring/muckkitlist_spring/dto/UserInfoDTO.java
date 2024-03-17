package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import muckkitlist_spring.muckkitlist_spring.entity.UniversityInfoEntity;

@Data
@RequiredArgsConstructor
public class UserInfoDTO {
  private final String userId;
  private final UniversityInfoDTO university;
  private final long point;
  private final String fcmToken;

  // 생성자, Getter 메서드는 롬복 라이브러리를 통해 자동으로 생성됨
}
