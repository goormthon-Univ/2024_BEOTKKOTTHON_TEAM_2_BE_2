package muckkitlist_spring.muckkitlist_spring.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "User_Favorite")
@Getter
@RequiredArgsConstructor
public class UserFavoriteEntity {
  @Id
  @Column(name = "user_id")
  private String userId;
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "restaurant_id")
  private RestaurantInfoEntity restaurantInfoEntity;

}
