package muckkitlist_spring.muckkitlist_spring.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "restaurant_info")
@Getter
@RequiredArgsConstructor
public class RestaurantInfoEntity {
  @Id
  @Column(name = "restaurant_id")
  private String restaurantId;

  @Column(name = "restaurant_name")
  private String restaurantName;

  @Column(name = "address")
  private String address;

  @Column(name = "review_count")
  private int reviewCount;

  @Column(name = "avg_grade")
  private double avgGrade;

  @Column(name = "link")
  private String link;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "category")
  private String category;
}


