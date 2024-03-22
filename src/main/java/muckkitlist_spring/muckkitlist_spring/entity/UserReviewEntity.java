package muckkitlist_spring.muckkitlist_spring.entity;

import lombok.Getter;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.Optional;

@Entity
@Table(name = "user_review")
@Getter
@RequiredArgsConstructor
public class UserReviewEntity {
  @Id
  @Column(name = "user_review_id")
  private String userReviewId;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "kakao_id")
  private UserInfoEntity userInfo;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "restaurant_id")
  private RestaurantInfoEntity restaurant;

  @Column(name = "star")
  private double star;

  @Column(name = "write_time")
  private LocalDate writeTime;

  @Column(name = "details")
  private String details;

  @Column(name = "like_count")
  private int like_count;

  public void setUserId(UserInfoEntity userInfo) {
    this.userInfo=userInfo;
  }

  public void setUserReviewId(String userReviewId) {
    this.userReviewId=userReviewId;
  }

  public void setUserInfo(UserInfoEntity userInfo) {
    this.userInfo=userInfo;
  }

  public void setRestaurant(RestaurantInfoEntity restaurant) {
    this.restaurant=restaurant;
  }

  public void setWriteTime(LocalDate writeTime) {
    this.writeTime=writeTime;
  }

  public void setLike_count(int like_count) {
    this.like_count=like_count;
  }

  public void setDetails(String details) {
    this.details=details;
  }

  public void setStar(double star) {
    this.star=star;
  }
}
