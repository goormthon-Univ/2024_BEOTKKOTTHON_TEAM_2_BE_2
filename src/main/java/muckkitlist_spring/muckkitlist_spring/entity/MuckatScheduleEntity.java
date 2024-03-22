package muckkitlist_spring.muckkitlist_spring.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;


@Entity
@Table(name = "muckat_schedule")
@Getter
@RequiredArgsConstructor
public class MuckatScheduleEntity {
  @Id
  @Column(name = "schedule_id")
  private String scheduleId;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "restaurant_id")
  private RestaurantInfoEntity restaurantInfoEntity;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "muckat_id")
  private MuckatListEntity muckatListEntity;

  @Column(name="timestamp")
  private LocalDate timestamp;

  public void setRestaurantEntity(RestaurantInfoEntity restaurantInfoEntity) {
    this.restaurantInfoEntity=restaurantInfoEntity;
  }
  public void setPersonalMuckatList(MuckatListEntity muckatListEntity) {
    this.muckatListEntity=muckatListEntity;
  }

  public void setScheduleId(String scheduleId) {
    this.scheduleId=scheduleId;
  }

  public void setTimeStamp(LocalDate now) {
    timestamp=now;
  }
}
