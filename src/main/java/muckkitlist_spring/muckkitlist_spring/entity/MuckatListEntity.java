package muckkitlist_spring.muckkitlist_spring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "muckat_list")
@Getter
@Setter
@RequiredArgsConstructor
public class MuckatListEntity {
  @Id
  @Column(name = "muckat_id")
  private String muckatId;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "kakao_id")
  private UserInfoEntity userInfoEntity;

  @Column(name="group_name")
  private String groupName;

  @Column(name = "room_master")
  private boolean roomMaster;
}
