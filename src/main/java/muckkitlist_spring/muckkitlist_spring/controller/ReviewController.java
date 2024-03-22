package muckkitlist_spring.muckkitlist_spring.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import muckkitlist_spring.muckkitlist_spring.dto.UserReviewClientDTO;
import muckkitlist_spring.muckkitlist_spring.dto.UserReviewDTO;
import muckkitlist_spring.muckkitlist_spring.service.UserReviewService;
import muckkitlist_spring.muckkitlist_spring.utility.UserReviewMapper;
import muckkitlist_spring.muckkitlist_spring.utility.UserReviewToClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@Tag(name = "REVIEW", description = "리뷰 관련 API")

public class ReviewController {

    private final UserReviewService reviewService;
    private final UserReviewMapper userReviewMapper;
    private final UserReviewToClientMapper userReviewToClientMapper;
    @Autowired
    public ReviewController(UserReviewService reviewService, UserReviewMapper userReviewMapper, UserReviewToClientMapper userReviewToClientMapper) {
        this.reviewService = reviewService;
        this.userReviewMapper = userReviewMapper;
        this.userReviewToClientMapper = userReviewToClientMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserReviewClientDTO>> getAllReviews() {
        List<UserReviewClientDTO> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }


    @GetMapping("/{userId}")
    @Operation(summary = "모든 리뷰", description = "유저 아이디로 쓴 모든 리뷰를 조회합니다.")
    public ResponseEntity<List<UserReviewClientDTO>> getUserReviews(@PathVariable String userId) {
        List<UserReviewClientDTO> userReviews = reviewService.getUserReviewsByUserId(userId);
        return ResponseEntity.ok(userReviews);
    }
/*
    @GetMapping("/restaurant/{restaurantId}")
    @Operation(summary = "특정 맛집에 쓴 리뷰", description = "해당 맛집에 작성된 모든 리뷰를 받아옵니다.")
    public ResponseEntity<List<UserReviewDTO>> getUserReviewsByRestaurantId(@PathVariable String restaurantId) {
        List<UserReviewDTO> userReviews = reviewService.getUserReviewsByRestaurantId(restaurantId);
        return ResponseEntity.ok(userReviews);
    }
*/
    @GetMapping("/{userId}/{restaurantId}")
    @Operation(summary = "특정 맛집에 특정 유저가 작성한 리뷰", description = "특정 맛집에 특정 유저가 작성한 리뷰를 모두 받아옵니다.")
    public ResponseEntity<List<UserReviewClientDTO>> getUserReviewsByUserIdAndRestaurantId(@PathVariable String userId, @PathVariable String restaurantId) {
        List<UserReviewClientDTO> userReviews = reviewService.getUserReviewsByUserIdAndRestaurantId(userId,restaurantId);
        return ResponseEntity.ok(userReviews);
    }

    @GetMapping("/{restaurantId}/{selectStandard}/{sortBy}")
    @Operation(summary = "특정 맛집에 쓴 리뷰", description = "해당 맛집에 작성된 리뷰를 어떤 방식으로 정렬하여 받아옵니다.")
    public ResponseEntity<List<UserReviewClientDTO>> getUserReviewsByRestaurantId(
            @PathVariable String restaurantId,
            @PathVariable String selectStandard,
            @PathVariable String sortBy) {
        List<UserReviewClientDTO> userReviews;
        if (selectStandard.equals("star")) {
            userReviews = sortBy.equals("ASC") ?
                    reviewService.getUserReviewsByRestaurantIdByStar(restaurantId, "ASC") :
                    reviewService.getUserReviewsByRestaurantIdByStar(restaurantId, "DESC");
        } else if (selectStandard.equals("like_count")) {
            userReviews = sortBy.equals("ASC") ?
                    reviewService.getUserReviewsByRestaurantIdByLikeCount(restaurantId, "ASC") :
                   reviewService.getUserReviewsByRestaurantIdByLikeCount(restaurantId, "DESC");
        } else {
            // 올바르지 않은 정렬 기준을 사용하는 경우, 기본적으로 정렬되지 않은 리뷰를 반환합니다.
            userReviews = reviewService.getUserReviewsByRestaurantId(restaurantId);
        }


        return ResponseEntity.ok(userReviews);
    }

    @PostMapping("/update")
    @Operation(summary = "특정 리뷰 업데이트", description = "리뷰id를 통해 특정 리뷰를 업데이트합니다.유저리뷰id와 star그리고 세부사항이 필요합니다.")
    public ResponseEntity<List<UserReviewClientDTO>> updateUserReviewsByUserIdAndRestaurantId(
            @RequestBody UserReviewClientDTO updatedReviewDTO
    ) {
        UserReviewClientDTO updatedReviews = reviewService.updateUserReview(updatedReviewDTO);
        return ResponseEntity.ok(Collections.singletonList(updatedReviews));
    }

    @PostMapping("/update/like-count")
    @Operation(summary = "특정 리뷰 업데이트", description = "리뷰id를 통해 특정 리뷰에 대한 좋아요(like_count)를 업데이트합니다.유저리뷰id와 ")
    public ResponseEntity<List<UserReviewClientDTO>> updateLikeCount(
            @RequestBody UserReviewClientDTO updatedReviewDTO
    ) {
        UserReviewClientDTO updatedReviews = reviewService.updateUserReview(updatedReviewDTO);
        return ResponseEntity.ok(Collections.singletonList(updatedReviews));
    }







    @PostMapping("/create")
    @Operation(summary = "리뷰 생성", description = "리뷰를 생성합니다.")
    public ResponseEntity<UserReviewClientDTO> createReview(@RequestBody UserReviewClientDTO userReviewClientDTO) {
        // 현재 날짜를 LocalDate로 가져오기
        LocalDate writeTime = LocalDate.now();

        // createReview 메서드 호출하여 리뷰 생성
        UserReviewClientDTO createdReview = reviewService.createReview(userReviewClientDTO);

        // 생성된 리뷰를 ResponseEntity에 담아 반환
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }


    @DeleteMapping("/{userReviewId}")
    @Operation(summary = "리뷰삭제", description = "특정한 리뷰 아이디값의 리뷰를 삭제합니다.")
    public ResponseEntity<Void> deleteReview(@PathVariable String userReviewId) {
        reviewService.deleteUserReview(userReviewId);
        return ResponseEntity.noContent().build();
    }
}
