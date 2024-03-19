package muckkitlist_spring.muckkitlist_spring.service;

import muckkitlist_spring.muckkitlist_spring.dto.UserReviewDTO;
import muckkitlist_spring.muckkitlist_spring.entity.UserReviewEntity;
import muckkitlist_spring.muckkitlist_spring.repository.UserReviewRepository;
import muckkitlist_spring.muckkitlist_spring.utility.UserReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserReviewService {

    private final UserReviewRepository reviewRepository;
    private final UserReviewMapper userReviewMapper;

    @Autowired
    public UserReviewService(UserReviewRepository reviewRepository, UserReviewMapper userReviewMapper) {
        this.reviewRepository = reviewRepository;
        this.userReviewMapper = userReviewMapper;
    }

    public List<UserReviewDTO> getAllReviews() {
        List<UserReviewEntity> reviewEntities = reviewRepository.findAll();
        return reviewEntities.stream()
                .map(userReviewMapper::toDto)
                .collect(Collectors.toList());
    }



    /*
    public UserReviewDTO createReview(UserReviewDTO reviewDTO) {
        UserReviewEntity reviewEntity = userReviewMapper.map(reviewDTO, UserReviewEntity.class);
        reviewEntity = reviewRepository.save(reviewEntity);
        return userReviewMapper.map(reviewEntity, UserReviewDTO.class);
    }

    public UserReviewDTO updateUserReview(Long userReviewId, UserReviewDTO reviewDTO) {
        UserReviewEntity existingEntity = reviewRepository.findById(userReviewId)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + userReviewId));
        modelMapper.map(reviewDTO, existingEntity);
        existingEntity.setUserReviewId(userReviewId);
        existingEntity = reviewRepository.save(existingEntity);
        return modelMapper.map(existingEntity, UserReviewDTO.class);
    }
*/
    public void deleteUserReview(String userReviewId) {
        reviewRepository.deleteById(userReviewId);
    }

}
