package muckkitlist_spring.muckkitlist_spring.service;

import jakarta.persistence.EntityManager;
import muckkitlist_spring.muckkitlist_spring.dto.RestaurantInfoDTO;
import muckkitlist_spring.muckkitlist_spring.dto.UserReviewClientDTO;
import muckkitlist_spring.muckkitlist_spring.dto.UserReviewDTO;
import muckkitlist_spring.muckkitlist_spring.entity.RestaurantInfoEntity;
import muckkitlist_spring.muckkitlist_spring.entity.UserInfoEntity;
import muckkitlist_spring.muckkitlist_spring.entity.UserReviewEntity;
import muckkitlist_spring.muckkitlist_spring.repository.RestaurantInfoRepository;
import muckkitlist_spring.muckkitlist_spring.repository.UniversityInfoRepository;
import muckkitlist_spring.muckkitlist_spring.repository.UserInfoRepository;
import muckkitlist_spring.muckkitlist_spring.repository.UserReviewRepository;
import muckkitlist_spring.muckkitlist_spring.utility.UserReviewMapper;
import muckkitlist_spring.muckkitlist_spring.utility.UserReviewToClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserReviewService {

    private final UserReviewRepository reviewRepository;
    private final UserReviewMapper userReviewMapper;
    private final UserInfoRepository userInfoRepository;
    private final RestaurantInfoRepository restaurantInfoRepository;

    private final UserReviewToClientMapper userReviewToClientMapper;
    @Autowired
    public UserReviewService(UserReviewRepository reviewRepository, UserReviewMapper userReviewMapper, UserInfoRepository userInfoRepository, UniversityInfoRepository universityInfoRepository, RestaurantInfoRepository restaurantInfoRepository, UserReviewToClientMapper userReviewToClientMapper) {
        this.reviewRepository = reviewRepository;
        this.userReviewMapper = userReviewMapper;
        this.userInfoRepository = userInfoRepository;
        this.restaurantInfoRepository = restaurantInfoRepository;
        this.userReviewToClientMapper = userReviewToClientMapper;
    }

    public List<UserReviewClientDTO> getAllReviews() {
        List<UserReviewEntity> reviewEntities = reviewRepository.findAll();
        return reviewEntities.stream()
                .map(userReviewMapper::toDTO).map(userReviewToClientMapper::toClientDTO)
                .collect(Collectors.toList());
    }
    public List<UserReviewClientDTO> getUserReviewsByUserId(String kakaoId) {
        List<UserReviewEntity> reviewEntities = reviewRepository.findByUserInfoKakaoId(kakaoId);

        return reviewEntities.stream().map(userReviewMapper::toDTO).map(userReviewToClientMapper::toClientDTO).collect(Collectors.toList());
    }


    public List<UserReviewClientDTO> getUserReviewsByRestaurantIdByStar(String restaurantId,String sortBy) {
        List<UserReviewEntity> reviewEntities;
        if(sortBy.equals("ASC")){
            reviewEntities=reviewRepository.findByRestaurantIdOrderByStarAsc(restaurantId);
        }
        else{
            reviewEntities=reviewRepository.findByRestaurantIdOrderByStarDESC(restaurantId);
        }
        return reviewEntities.stream().map(userReviewMapper::toDTO).map(userReviewToClientMapper::toClientDTO).collect(Collectors.toList());

    }

    public List<UserReviewClientDTO> getUserReviewsByRestaurantIdByLikeCount(String restaurantId,String sortBy) {
        List<UserReviewEntity> reviewEntities;
        if(sortBy.equals("ASC")){
            reviewEntities=reviewRepository.findByRestaurantIdOrderByLikeCountASC(restaurantId);
        }
        else{
            reviewEntities=reviewRepository.findByRestaurantIdOrderByLikeCountDesc(restaurantId);
        }
        return reviewEntities.stream().map(userReviewMapper::toDTO).map(userReviewToClientMapper::toClientDTO).collect(Collectors.toList());

    }

    public List<UserReviewClientDTO> getUserReviewsByRestaurantIdByWriteTime(String restaurantId, String sortBy) {
        List<UserReviewEntity> reviewEntities;
        if(sortBy.equals("ASC")){
            reviewEntities=reviewRepository.findByRestaurantIdOrderByWriteTimeAsc(restaurantId);
        }
        else{
            reviewEntities=reviewRepository.findByRestaurantIdOrderByWriteTimeDesc(restaurantId);
        }
        return reviewEntities.stream().map(userReviewMapper::toDTO).map(userReviewToClientMapper::toClientDTO).collect(Collectors.toList());

    }





//리뷰를 생성한다면 가게의 리뷰카운트도1증가 리뷰를 삭제하면 리뷰카운트 1감소
    public UserReviewClientDTO createReview(@RequestBody UserReviewClientDTO userReviewClientDTO) {
        // 사용자 정보와 음식점 정보 가져오기
        Optional<UserInfoEntity> userInfoEntityOptional = userInfoRepository.findById(userReviewClientDTO.getKakaoId());
        Optional<RestaurantInfoEntity> restaurantInfoEntityOptional = restaurantInfoRepository.findById(userReviewClientDTO.getRestaurantName());


        // 사용자 정보와 음식점 정보가 모두 존재하는 경우에만 리뷰 생성
        if (userInfoEntityOptional.isPresent() && restaurantInfoEntityOptional.isPresent()) {
            // 리뷰 엔티티 생성 및 설정
            UserReviewEntity reviewEntity = new UserReviewEntity();
            UUID uuid4 = UUID.randomUUID();
            reviewEntity.setUserReviewId(uuid4.toString());//적은 id값 무시하고 랜덤으로적용
            reviewEntity.setUserInfo(userInfoEntityOptional.get());
            reviewEntity.setRestaurant(restaurantInfoEntityOptional.get());
            reviewEntity.setStar(userReviewClientDTO.getStar());
            reviewEntity.setWriteTime(userReviewClientDTO.getWriteTime());
            reviewEntity.setDetails(userReviewClientDTO.getDetails());

            // 리뷰 저장
            UserReviewEntity createReviewEntity = reviewRepository.save(reviewEntity);
            int reviewCount = reviewRepository.countByRestaurantRestaurantId(userReviewClientDTO.getRestaurantName());
            restaurantInfoEntityOptional.get().setReviewCount(reviewCount);
            restaurantInfoRepository.save(restaurantInfoEntityOptional.get());
            System.out.println(reviewCount);
            // DTO로 변환하여 반환

            return userReviewToClientMapper.toClientDTO(userReviewMapper.toDTO(createReviewEntity));
        } else {
            // 사용자 정보 또는 음식점 정보가 없는 경우에는 예외 처리
            throw new IllegalArgumentException("User or restaurant not found");
        }
    }


    public UserReviewClientDTO updateUserReview(UserReviewClientDTO userReviewClientDTO) {
        Optional<UserReviewEntity> reviewPackage = reviewRepository.findById(userReviewClientDTO.getUserReviewId());
        if (reviewPackage.isPresent()) {
            // 리뷰가 존재하는지 확인
                // 기존 리뷰 엔티티 가져오기
                UserReviewEntity reviewEntity = reviewPackage.get();

                // 변경된 정보로 업데이트
                reviewEntity.setStar(userReviewClientDTO.getStar());
                reviewEntity.setWriteTime(userReviewClientDTO.getWriteTime());
                reviewEntity.setDetails(userReviewClientDTO.getDetails());
                // 리뷰 저장
                UserReviewEntity updatedReviewEntity = reviewRepository.save(reviewEntity);
                // 리뷰 개수 업데이트
                Optional<RestaurantInfoEntity> restaurantInfoEntity=restaurantInfoRepository.findById(reviewEntity.getRestaurant().getRestaurantId());
                if(restaurantInfoEntity.isPresent()) {
                    int reviewCount = reviewRepository.countByRestaurantRestaurantId(userReviewClientDTO.getRestaurantName());
                    restaurantInfoEntity.get().setReviewCount(reviewCount);
                    restaurantInfoRepository.save(restaurantInfoEntity.get());
                }
                // DTO로 변환하여 반환
                return userReviewToClientMapper.toClientDTO(userReviewMapper.toDTO(updatedReviewEntity));
            } else {
                // 업데이트할 리뷰가 존재하지 않는 경우 예외 처리
                throw new IllegalArgumentException("User review not found");
            }
        }


//따봉부분 작성요망

    public void deleteUserReview(String userReviewId) {
        // 삭제할 리뷰 정보 가져오기
        Optional<UserReviewEntity> reviewEntityOptional = reviewRepository.findById(userReviewId);

        // 리뷰가 존재하는 경우에만 삭제 및 업데이트 진행
        if (reviewEntityOptional.isPresent()) {
            UserReviewEntity reviewEntity = reviewEntityOptional.get();
            String restaurantId = reviewEntity.getRestaurant().getRestaurantId();

            // 리뷰 삭제
            reviewRepository.deleteById(userReviewId);

            // 음식점 리뷰 개수 업데이트
            int reviewCount = reviewRepository.countByRestaurantRestaurantId(restaurantId);
            Optional<RestaurantInfoEntity> restaurantInfoOptional = restaurantInfoRepository.findById(restaurantId);
            restaurantInfoOptional.ifPresent(restaurantInfo -> {
                restaurantInfo.setReviewCount(reviewCount);
                restaurantInfoRepository.save(restaurantInfo);
            });
        } else {
            throw new IllegalArgumentException("Review not found");
        }
    }

    public List<UserReviewClientDTO> getUserReviewsByRestaurantId(String restaurantId) {
        List<UserReviewEntity> reviewEntities=reviewRepository.findByRestaurantId(restaurantId);
        return reviewEntities.stream().map(userReviewMapper::toDTO).map(userReviewToClientMapper::toClientDTO).collect(Collectors.toList());

    }

    public List<UserReviewClientDTO> getUserReviewsByUserIdAndRestaurantId(String userId, String restaurantId) {
        List<UserReviewEntity> reviewEntities=reviewRepository.findByUserInfoKakaoIdAndRestaurantInfoRestaurantId(userId,restaurantId);
        return reviewEntities.stream().map(userReviewMapper::toDTO).map(userReviewToClientMapper::toClientDTO).collect(Collectors.toList());

    }


    public UserReviewClientDTO updateUserReviewLikeCount(UserReviewClientDTO updatedReviewDTO,boolean push) {
        Optional<UserReviewEntity> reviewPackage = reviewRepository.findById(updatedReviewDTO.getUserReviewId());
        if (reviewPackage.isPresent()) {
            UserReviewEntity reviewEntity = reviewPackage.get();
            if(push==true) {
                int n = reviewEntity.getLike_count();
                n=n+1;
                // 변경된 정보로 업데이트
                reviewEntity.setLike_count(n);
                // 리뷰 저장
                UserReviewEntity updatedReviewEntity = reviewRepository.save(reviewEntity);

                // DTO로 변환하여 반환
                return userReviewToClientMapper.toClientDTO(userReviewMapper.toDTO(updatedReviewEntity));
            }
            else{
                int n = reviewEntity.getLike_count();
                n=n-1;
                // 변경된 정보로 업데이트
                reviewEntity.setLike_count(n);
                // 리뷰 저장
                UserReviewEntity updatedReviewEntity = reviewRepository.save(reviewEntity);

                // DTO로 변환하여 반환
                return userReviewToClientMapper.toClientDTO(userReviewMapper.toDTO(updatedReviewEntity));
            }
                } else {
                // 업데이트할 리뷰가 존재하지 않는 경우 예외 처리
                throw new IllegalArgumentException("User review not found");
        }




    }


}
