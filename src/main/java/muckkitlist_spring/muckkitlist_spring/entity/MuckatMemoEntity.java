package muckkitlist_spring.muckkitlist_spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import muckkitlist_spring.muckkitlist_spring.utility.MuckatMemoComposite;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "muckat_memo")
@Setter
@Getter
@IdClass(MuckatMemoComposite.class)
public class MuckatMemoEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RestaurantInfoEntity restaurantInfoEntity;

    @Id
    @ManyToOne
    @JoinColumn(name = "muckat_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MuckatListEntity muckatListEntity;

    @Column(name= "is_check")
    private boolean isCheck;


    public void setIsCheck(boolean isCheck) {
        this.isCheck=isCheck;
    }
}
