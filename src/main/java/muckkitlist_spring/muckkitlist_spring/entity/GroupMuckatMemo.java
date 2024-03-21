package muckkitlist_spring.muckkitlist_spring.entity;

import jakarta.persistence.*;
import muckkitlist_spring.muckkitlist_spring.utility.GroupMuckatMemoComposite;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "group_muckat_memo")
@IdClass(GroupMuckatMemoComposite.class)
public class GroupMuckatMemo {

    @Id
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RestaurantInfoEntity restaurantInfoEntity;

    @Id
    @ManyToOne
    @JoinColumn(name = "group_muckat_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private GroupMuckatListEntity groupMuckatListEntity;

}
