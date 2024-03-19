package muckkitlist_spring.muckkitlist_spring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table(name = "image_group")
@Getter
@RequiredArgsConstructor
public class ImageGroupEntity {
  @Id
  @Column(name = "image_group_id")
  private String imageGroupId;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "groupmuckat_id")
  private GroupMuckatListEntity groupMuckatListEntity;

  @Column(name= "timestamp")
  private LocalDate timestamp;
}
