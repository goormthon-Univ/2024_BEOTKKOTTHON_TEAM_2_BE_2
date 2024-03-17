package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class KakaoLoginDTO {
  private String code;
  private String refreshToken;
  private String kakaoId;

}
