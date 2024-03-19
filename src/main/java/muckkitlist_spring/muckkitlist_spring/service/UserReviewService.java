package muckkitlist_spring.muckkitlist_spring.service;

import muckkitlist_spring.muckkitlist_spring.dto.RestaurantInfoDTO;
import muckkitlist_spring.muckkitlist_spring.dto.UserReviewDTO;
import muckkitlist_spring.muckkitlist_spring.entity.RestaurantInfoEntity;
import muckkitlist_spring.muckkitlist_spring.entity.UserInfoEntity;
import muckkitlist_spring.muckkitlist_spring.entity.UserReviewEntity;
import muckkitlist_spring.muckkitlist_spring.repository.RestaurantInfoRepository;
import muckkitlist_spring.muckkitlist_spring.repository.UniversityInfoRepository;
import muckkitlist_spring.muckkitlist_spring.repository.UserInfoRepository;
import muckkitlist_spring.muckkitlist_spring.repository.UserReviewRepository;
import muckkitlist_spring.muckkitlist_spring.utility.UserReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserReviewService {

    private final UserReviewRepository reviewRepository;
    private final UserReviewMapper userReviewMapper;
    private final UserInfoRepository userInfoRepository;
    private final RestaurantInfoRepository restaurantInfoRepository;

    @Autowired
    public UserReviewService(UserReviewRepository reviewRepository, UserReviewMapper userReviewMapper, UserInfoRepository userInfoRepository, UniversityInfoRepository universityInfoRepository, RestaurantInfoRepository restaurantInfoRepository) {
        this.reviewRepository = reviewRepository;
        this.userReviewMapper = userReviewMapper;
        this.userInfoRepository = userInfoRepository;
        this.restaurantInfoRepository = restaurantInfoRepository;
    }

    public List<UserReviewDTO> getAllReviews() {
        List<UserReviewEntity> reviewEntities = reviewRepository.findAll();
        return reviewEntities.stream()
                .map(userReviewMapper::toDto)
                .collect(Collectors.toList());
    }
    public List<UserReviewDTO> getUserReviewsByUserId(String userId) {
        List<UserReviewEntity> reviewEntities = reviewRepository.findByUserInfoUserId(userId);
        return reviewEntities.stream().map(userReviewMapper::toDto).collect(Collectors.toList());
    }


    public UserReviewDTO createReview(String userReviewId, String userId, String restaurantId,
                                      double star, LocalDate writeTime, String details, String likeCount) {
        // 사용자 정보와 음식점 정보 가져오기
        Optional<UserInfoEntity> userInfoEntityOptional = userInfoRepository.findById(userId);
        Optional<RestaurantInfoEntity> restaurantInfoEntityOptional = restaurantInfoRepository.findById(restaurantId);

        // 사용자 정보와 음식점 정보가 모두 존재하는 경우에만 리뷰 생성
        if (userInfoEntityOptional.isPresent() && restaurantInfoEntityOptional.isPresent()) {
            // 리뷰 엔티티 생성 및 설정
            UserReviewEntity reviewEntity = new UserReviewEntity();
            reviewEntity.setUserReviewId(userReviewId);
            reviewEntity.setUserInfo(userInfoEntityOptional.get());
            reviewEntity.setRestaurant(restaurantInfoEntityOptional.get());
            reviewEntity.setStar(star);
            reviewEntity.setWriteTime(writeTime.toString());
            reviewEntity.setDetails(details);
            reviewEntity.setLike_count(likeCount);

            // 리뷰 저장
            UserReviewEntity createReviewEntity = reviewRepository.save(reviewEntity);

            // DTO로 변환하여 반환
            return userReviewMapper.toDto(createReviewEntity);
        } else {
            // 사용자 정보 또는 음식점 정보가 없는 경우에는 예외 처리
            throw new IllegalArgumentException("User or restaurant not found");
        }
    }




    public void deleteUserReview(String userReviewId) {
        reviewRepository.deleteById(userReviewId);
    }

    public List<UserReviewDTO> getUserReviewsByRestaurantId(String restaurantId) {
        List<UserReviewEntity> reviewEntities=reviewRepository.findByRestaurantId(restaurantId);
        return reviewEntities.stream().map(userReviewMapper::toDto).collect(Collectors.toList());

    }

    public List<UserReviewDTO> getUserReviewsByUserIdAndRestaurantId(String userId, String restaurantId) {
        List<UserReviewEntity> reviewEntities=reviewRepository.findByUserInfoUserIdAndRestaurantInfoRestaurantId(userId,restaurantId);
        return reviewEntities.stream().map(userReviewMapper::toDto).collect(Collectors.toList());

    }

    public UserReviewDTO updateUserReview(String userReviewId, UserReviewDTO updatedReviewDTO) {
        UserReviewEntity existingEntity = reviewRepository.findById(userReviewId)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + userReviewId));

        // 업데이트된 정보로 기존 엔티티 업데이트
        existingEntity.setStar(updatedReviewDTO.getStar());
        existingEntity.setWriteTime(updatedReviewDTO.getWriteTime());
        existingEntity.setDetails(updatedReviewDTO.getDetails());
        existingEntity.setLike_count(updatedReviewDTO.getLike_count());

        // 데이터베이스에 저장
        existingEntity = reviewRepository.save(existingEntity);

        // 업데이트된 리뷰 정보를 DTO로 변환하여 반환
        return userReviewMapper.toDto(existingEntity);
    }





}
