package muckkitlist_spring.muckkitlist_spring.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


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
  private boolean checks;

  @Setter
  @Column(name = "group_check")
  private boolean groups;


  public void setMuckatListId(String muckatlistId) {
    this.muckatlistId=muckatlistId;
  }

  public void setRestaurantId(RestaurantInfoEntity restaurant) {
    this.restaurant=restaurant;
  }

  public void setIsChecked(boolean checks) {
    this.checks=checks;
  }

  public void setGroup(boolean groups) {
    this.groups=groups;
  }
}
