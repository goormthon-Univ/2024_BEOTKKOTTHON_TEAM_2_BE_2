package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RestaurantInfoDTO {
  private final String restaurantId;
  private final String restaurantName;
  private final String address;
  private final long reviewCount;
  private final double avgGrade;
  private final String link;
  private final String phoneNumber;
  private final String category;

}

