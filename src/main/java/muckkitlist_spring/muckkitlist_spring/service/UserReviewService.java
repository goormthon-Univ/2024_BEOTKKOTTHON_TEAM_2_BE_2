package muckkitlist_spring.muckkitlist_spring.service;

import muckkitlist_spring.muckkitlist_spring.dto.UserReviewDTO;
import muckkitlist_spring.muckkitlist_spring.entity.UserReviewEntity;
import muckkitlist_spring.muckkitlist_spring.repository.UserReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReviewService {

    private final UserReviewRepository reviewRepository;

    @Autowired
    public UserReviewService(UserReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<UserReviewDTO> getAllReviews() {
        // Implement logic to fetch all reviews
        return null;
    }

    public List<UserReviewDTO> getUserReviews(Long userReviewId) {
        // Implement logic to fetch reviews for a specific user
        return null;
    }

    public List<UserReviewDTO> getRestaurantReviews(Long restaurantId, String state) {
        // Implement logic to fetch reviews for a specific restaurant
        return null;
    }

    public UserReviewDTO createReview(UserReviewDTO reviewDTO) {
        // Implement logic to create a new review
        return null;
    }

    public UserReviewDTO updateUserReview(Long userReviewId, UserReviewDTO reviewDTO) {
        // Implement logic to update a user review
        return null;
    }

    public void deleteUserReview(Long userReviewId) {
        // Implement logic to delete a user review
    }
}
