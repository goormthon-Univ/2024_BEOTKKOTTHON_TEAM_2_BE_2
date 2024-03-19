package muckkitlist_spring.muckkitlist_spring.controller;


import muckkitlist_spring.muckkitlist_spring.dto.UserReviewDTO;
import muckkitlist_spring.muckkitlist_spring.service.UserReviewService;
import muckkitlist_spring.muckkitlist_spring.utility.UserReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final UserReviewService reviewService;
    private final UserReviewMapper userReviewMapper;

    @Autowired
    public ReviewController(UserReviewService reviewService, UserReviewMapper userReviewMapper) {
        this.reviewService = reviewService;
        this.userReviewMapper = userReviewMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserReviewDTO>> getAllReviews() {
        List<UserReviewDTO> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    /*
    @GetMapping("/{userReviewId}")
    public ResponseEntity<List<UserReviewDTO>> getUserReviews(@PathVariable String userReviewId) {
        List<UserReviewDTO> userReviews = reviewService.getUserReviews(userReviewId);
        return ResponseEntity.ok(userReviews);
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<List<UserReviewDTO>> getRestaurantReviews(
            @PathVariable String restaurantId,
            @RequestParam(required = false) String state
    ) {
        List<UserReviewDTO> restaurantReviews = reviewService.getRestaurantReviews(restaurantId, state);
        return ResponseEntity.ok(restaurantReviews);
    }
    */
/*
    @PostMapping
    public ResponseEntity<UserReviewDTO> createReview(@RequestBody UserReviewDTO reviewDTO) {
        UserReviewDTO createdReview = reviewService.createReview(reviewDTO);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }

    @PatchMapping("/{userReviewId}")
    public ResponseEntity<UserReviewDTO> updateUserReview(
            @PathVariable Long userReviewId,
            @RequestBody UserReviewDTO reviewDTO
    ) {
        UserReviewDTO updatedReview = reviewService.updateUserReview(userReviewId, reviewDTO);
        return ResponseEntity.ok(updatedReview);
    }
*/
}
