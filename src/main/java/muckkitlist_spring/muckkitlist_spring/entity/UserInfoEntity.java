package muckkitlist_spring.muckkitlist_spring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "User_Info")
@Getter
@RequiredArgsConstructor
public class UserInfoEntity {
  @Id
  @Column(name = "user_id")
  private String userId;
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "university_name")
  private UniversityInfoEntity university;

  @Column(name = "point")
  private long point;

  @Column(name = "fcm_token")
  private String fcmToken;
}
