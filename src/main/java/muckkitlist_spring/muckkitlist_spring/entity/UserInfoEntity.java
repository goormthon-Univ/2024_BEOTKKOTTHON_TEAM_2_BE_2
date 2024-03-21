package muckkitlist_spring.muckkitlist_spring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "user_info")
@Getter
@Setter
@RequiredArgsConstructor
public class UserInfoEntity {
  @Id
  @Column(name = "kakao_id")
  private String kakaoId;
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "university_name")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private UniversityInfoEntity university;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "fcm_token")
  private String fcmToken;

  @Column(name = "point")
  private int point;

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public void updateUniversityInfo(UniversityInfoEntity university) {
    this.university = university;
  }

  public void setUniversityEntity(UniversityInfoEntity university) {
    this.university=university;
  }

}
