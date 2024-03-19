package muckkitlist_spring.muckkitlist_spring.entity;


import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "image_db")
@Getter
@RequiredArgsConstructor
public class ImageDbEntity {
  @Id
  @Column(name = "image_id")
  private String imageId;
  @Column(name = "image_timestamp")
  private LocalDate imageTimestamp;

}
