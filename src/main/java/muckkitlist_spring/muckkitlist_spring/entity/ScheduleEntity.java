package muckkitlist_spring.muckkitlist_spring.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "Schedule")
@Getter
@RequiredArgsConstructor
public class ScheduleEntity {
  @Id
  @Column(name = "schedule_id")
  private String scheduleId;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "restaurant_id")
  private RestaurantInfoEntity restaurantInfoEntity;

  @Column(name = "group_schedule")
  private long groupSchedule;

  @Column(name = "muckatlist_id")
  private String muckatlistId;

  @Column(name = "schedule_time")
  private java.sql.Date scheduleTime;

}
