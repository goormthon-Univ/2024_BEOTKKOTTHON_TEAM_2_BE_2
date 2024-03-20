package muckkitlist_spring.muckkitlist_spring.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name = "memo")
@Getter
@RequiredArgsConstructor
public class MemoEntity {

  @Id
  @Column(name = "muckatlist_id")
  private String muckatlistId;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "restaurant_id")
  private RestaurantInfoEntity restaurant;

  @Column(name = "checks")
  private boolean isCheck;

  @Column(name = "isGroup")
  private boolean isGroup;


  public void setMuckatListId(String muckatlistId) {
    this.muckatlistId=muckatlistId;
  }

  public void setRestaurantId(RestaurantInfoEntity restaurant) {
    this.restaurant=restaurant;
  }

  public void setIsChecked(boolean isCheck) {
    this.isCheck=isCheck;
  }

  public void setIsGroup(boolean isGroup) {
    this.isGroup=isGroup;
  }
}
