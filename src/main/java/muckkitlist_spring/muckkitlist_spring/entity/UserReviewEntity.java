package muckkitlist_spring.muckkitlist_spring.entity;

import lombok.Getter;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

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

  public void setUserId(UserInfoEntity userInfo) {
    this.userInfo=userInfo;
  }
  public void setRestaurantId(RestaurantInfoEntity restaurant) {
    this.restaurant=restaurant;
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

  public void setStar(double star) {
    this.star=star;
  }

  public void setWriteTime(String writeTime) {
    this.writeTime=writeTime;
  }

  public void setLike_count(String like_count) {
    this.like_count=like_count;
  }

  public void setDetails(String details) {
    this.details=details;
  }
}
