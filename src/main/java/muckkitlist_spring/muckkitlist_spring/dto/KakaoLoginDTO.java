package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class KakaoLoginDTO {
  private final String code;
  private final String refreshToken;
  private final String kakaoId;

}
