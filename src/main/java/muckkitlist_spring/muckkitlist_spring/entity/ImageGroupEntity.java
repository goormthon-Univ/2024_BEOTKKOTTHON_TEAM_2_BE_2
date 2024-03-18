package muckkitlist_spring.muckkitlist_spring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Image_Group")
@Getter
@RequiredArgsConstructor
public class ImageGroupEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "image_group_id")
  private Long imageGroupId;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "groupmuckat_id")
  private GroupMuckatListEntity groupMuckatListEntity;

  @Column(name = "image_src")
  private String imageSrc;
}
