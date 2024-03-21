package muckkitlist_spring.muckkitlist_spring.utility;

import muckkitlist_spring.muckkitlist_spring.dto.UserReviewClientDTO;
import muckkitlist_spring.muckkitlist_spring.dto.UserReviewDTO;
import org.springframework.stereotype.Component;

@Component
public class UserReviewToClientMapper {
    public UserReviewClientDTO toClientDTO(UserReviewDTO userReviewDTO) {
        return new UserReviewClientDTO(
                userReviewDTO.getUserReviewId(),
                userReviewDTO.getUserInfo().getKakaoId(),
                userReviewDTO.getRestaurant().getRestaurantName(),
                userReviewDTO.getStar(),
                userReviewDTO.getWriteTime(),
                userReviewDTO.getDetails(),
                userReviewDTO.getLike_count()
        );
    }

}
