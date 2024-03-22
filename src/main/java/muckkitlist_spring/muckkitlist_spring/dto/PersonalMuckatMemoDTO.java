package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PersonalMuckatMemoDTO {
    private final String restaurantId;
    private final String personalMuckatId;
    private final boolean check;

}
