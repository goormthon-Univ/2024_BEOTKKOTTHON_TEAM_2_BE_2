package muckkitlist_spring.muckkitlist_spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import muckkitlist_spring.muckkitlist_spring.utility.PersonalMuckatMemoComposite;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "personal_muckat_memo")
@Setter
@Getter
@IdClass(PersonalMuckatMemoComposite.class)
public class PersonalMuckatMemo {
    @Id
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RestaurantInfoEntity restaurantInfoEntity;

    @Id
    @ManyToOne
    @JoinColumn(name = "personal_muckat_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PersonalMuckatListEntity personalMuckatListEntity;
}
