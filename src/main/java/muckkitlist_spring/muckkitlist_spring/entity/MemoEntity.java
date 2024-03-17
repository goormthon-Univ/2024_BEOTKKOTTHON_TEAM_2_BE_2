package muckkitlist_spring.muckkitlist_spring.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "Memo")
@Getter
@RequiredArgsConstructor
public class MemoEntity {
  @Id
  @Column(name = "muckatlist_id")
  private String muckatlistId;
  @Column(name = "memo_id")
  private String memoId;
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "restaurant_id")
  private RestaurantInfoEntity restaurant;

}
