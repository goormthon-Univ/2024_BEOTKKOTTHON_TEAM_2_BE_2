package muckkitlist_spring.muckkitlist_spring.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "Image_personal")
@Getter
@RequiredArgsConstructor
public class ImagePersonalEntity {
  @Id
  @Column(name = "image_personal_id")
  private String imagePersonalId;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "user_id")
  private UserInfoEntity userInfoEntity;

  @Column(name = "image_src")
  private String imageSrc;

}
