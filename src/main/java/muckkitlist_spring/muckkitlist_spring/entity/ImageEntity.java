package muckkitlist_spring.muckkitlist_spring.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table(name = "image")
@Data
@RequiredArgsConstructor
public class ImageEntity {
  @Id
  @Column(name = "image_id")
  private String imageId;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "muckat_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private MuckatListEntity muckatListEntity;


  @Column(name= "timestamp")
  private LocalDate timestamp;
}
