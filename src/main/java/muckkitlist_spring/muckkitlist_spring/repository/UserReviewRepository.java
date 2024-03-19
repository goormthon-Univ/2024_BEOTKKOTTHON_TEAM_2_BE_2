package muckkitlist_spring.muckkitlist_spring.repository;

import muckkitlist_spring.muckkitlist_spring.entity.UserReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import muckkitlist_spring.muckkitlist_spring.entity.RestaurantInfoEntity;
import muckkitlist_spring.muckkitlist_spring.entity.UserInfoEntity;

import java.util.List;

@Repository
public interface UserReviewRepository extends JpaRepository<UserReviewEntity, String> {
    List<UserReviewEntity> findByUserReviewId(String userReviewId);
    List<UserReviewEntity> findByUserInfoUserId(String userId);

    @Query("SELECT ur FROM UserReviewEntity ur WHERE ur.restaurant.restaurantId = :restaurantId")
    List<UserReviewEntity> findByRestaurantId(@Param("restaurantId") String restaurantId);


    @Query("SELECT ur FROM UserReviewEntity ur " +
            "WHERE ur.userInfo.userId = :userId " +
            "AND ur.restaurant.restaurantId = :restaurantId")
    List<UserReviewEntity> findByUserInfoUserIdAndRestaurantInfoRestaurantId(
            @Param("userId") String userId,
            @Param("restaurantId") String restaurantId
    );}
