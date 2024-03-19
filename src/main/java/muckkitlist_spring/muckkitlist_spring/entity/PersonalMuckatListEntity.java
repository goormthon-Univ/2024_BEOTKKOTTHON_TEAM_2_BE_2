package muckkitlist_spring.muckkitlist_spring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "personal_muckat_list")
@Getter
@RequiredArgsConstructor
public class PersonalMuckatListEntity {
  @Id
  @Column(name = "personal_muckat_id")
  private String personalMuckatId;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "user_id")
  private UserInfoEntity user;

  @Column(name = "personal_name")
  private String personalName;
}
