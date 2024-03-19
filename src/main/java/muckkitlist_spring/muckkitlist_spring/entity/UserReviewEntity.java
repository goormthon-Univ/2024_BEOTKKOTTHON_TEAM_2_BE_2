package muckkitlist_spring.muckkitlist_spring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "user_review")
@Getter
@RequiredArgsConstructor
public class UserReviewEntity {
  @Id
  @Column(name = "user_review_id")
  private String userReviewId;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "user_id")
  private UserInfoEntity userInfo;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "restaurant_id")
  private RestaurantInfoEntity restaurant;

  @Column(name = "star")
  private double star;

  @Column(name = "write_time")
  private String writeTime;

  @Column(name = "details")
  private String details;

  @Column(name = "like_count")
  private String like_count;
}
