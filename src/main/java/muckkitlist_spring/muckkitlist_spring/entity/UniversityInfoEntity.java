package muckkitlist_spring.muckkitlist_spring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "university_info")
@Getter
@RequiredArgsConstructor
public class UniversityInfoEntity {
  @Id
  @Column(name = "university_name")
  private String universityName;

  @Column(name = "address")
  private String address;

  @Column(name = "position_x")
  private double positionX;

  @Column(name = "position_y")
  private double positionY;
}
