package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RestaurantInfoDTO {
  private String restaurantId;
  private String restaurantName;
  private String address;
  private long reviewCount;
  private double avgGrade;
  private String link;
  private String phoneNumber;
  private String category;

}

