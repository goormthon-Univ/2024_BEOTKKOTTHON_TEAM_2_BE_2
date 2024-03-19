package muckkitlist_spring.muckkitlist_spring.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name = "kakao_login")
@Getter
@RequiredArgsConstructor
public class KakaoLoginEntity {
  @Id
  @Column(name = "code")
  private String code;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "user_id")
  private UserInfoEntity userInfoEntity;

  @Column(name = "refresh_token")
  private String refreshToken;

}
