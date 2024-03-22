package muckkitlist_spring.muckkitlist_spring.entity;

import lombok.Getter;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "muckat_list")
@Getter
@Setter
@RequiredArgsConstructor
public class MuckatListEntity {
  @Id
  @Column(name="muckat_id")
  private String muckatId;

  @Column(name="group_name")
  private String groupName;

}
