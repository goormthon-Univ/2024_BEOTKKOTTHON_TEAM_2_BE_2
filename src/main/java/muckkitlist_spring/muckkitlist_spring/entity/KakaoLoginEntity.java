package muckkitlist_spring.muckkitlist_spring.entity;


import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name = "KakaoLogin")
@Getter
@RequiredArgsConstructor
public class KakaoLoginEntity {
  @Id
  @Column(name = "code")
  private String code;
  @Column(name = "refresh_token")
  private String refreshToken;
  @Column(name = "kakao_id")
  private String kakaoId;

}
