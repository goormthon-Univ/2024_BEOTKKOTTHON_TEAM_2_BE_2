package muckkitlist_spring.muckkitlist_spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
@Entity
@Table(name = "group_muckat_schedule")
@Getter
@RequiredArgsConstructor
public class GroupMuckatScheduleEntity {

    @Id
    @Column(name = "schedule_id")
    private String scheduleId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "restaurant_id")
    private RestaurantInfoEntity restaurantInfoEntity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "group_muckat_id")
    private GroupMuckatListEntity groupMuckatListEntity;

    @Column(name = "timestamp")
    private LocalDate timestamp;
}
