package muckkitlist_spring.muckkitlist_spring.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;


@Entity
@Table(name = "image")
@Getter
@RequiredArgsConstructor
public class ImageEntity {
  @Id
  @Column(name = "image_id")
  private String imageId;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "muckat_id")
  private MuckatListEntity muckatListEntity;

  @Column(name= "timestamp")
  private LocalDate timestamp;
}
