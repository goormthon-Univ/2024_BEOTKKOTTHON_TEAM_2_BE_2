package muckkitlist_spring.muckkitlist_spring.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;


@Entity
@Table(name = "image_personal")
@Getter
@RequiredArgsConstructor
public class ImagePersonalEntity {
  @Id
  @Column(name = "image_personal_id")
  private String imagePersonalId;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "personal_muckat_id")
  private PersonalMuckatListEntity personalMuckatListEntity;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "user_id")
  private UserInfoEntity userInfoEntity;

  @Column(name= "timestamp")
  private LocalDate timestamp;
}
