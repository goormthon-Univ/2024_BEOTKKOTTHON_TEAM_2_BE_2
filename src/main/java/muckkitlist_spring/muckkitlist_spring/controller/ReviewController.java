package muckkitlist_spring.muckkitlist_spring.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Response 2", description = "Response Estimate API")

@RequestMapping("/api/reviews")
public class ReviewController {
    @GetMapping
    public ResponseEntity<?> getAllReviews() {
        return ResponseEntity.ok("하이");
    }

    @GetMapping("/{userReviewId}")
    public ResponseEntity<?> getReviewById(@PathVariable Long userReviewId) {
            return ResponseEntity.ok("엥");

    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<?> getReviewsByRestaurantId(@PathVariable Long restaurantId, @RequestParam(required = false) String viewState) {

        return ResponseEntity.ok("ok");
    }

    @PostMapping
    public ResponseEntity<?> createReview(@RequestBody Review review) {

        return ResponseEntity.status(HttpStatus.CREATED).body("ok");
    }

    @PatchMapping("/{userReviewId}")
    public ResponseEntity<?> updateReview(@PathVariable Long userReviewId, @RequestBody Review review) {

            return ResponseEntity.ok("ok");

    }

    @DeleteMapping("/{userReviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable Long userReviewId) {
            return ResponseEntity.ok("Review deleted successfully");

    }
}
