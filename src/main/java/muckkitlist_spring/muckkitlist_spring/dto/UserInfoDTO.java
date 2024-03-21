package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserInfoDTO {
  private final String kakaoId;
  private final String userId;
  private final UniversityInfoDTO university; // 대학 정보 DTO로 변경
  private final long point;
  private final String fcmToken;
}
