package muckkitlist_spring.muckkitlist_spring.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;


@Entity
@Table(name = "personal_muckat_schedule")
@Getter
@RequiredArgsConstructor
public class PersonalMuckatScheduleEntity {
  @Id
  @Column(name = "schedule_id")
  private String scheduleId;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "restaurant_id")
  private RestaurantInfoEntity restaurantInfoEntity;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "personal_muckat_id")
  private PersonalMuckatListEntity personalMuckatListEntity;

  @Column(name="timestamp")
  private LocalDate timestamp;

}
