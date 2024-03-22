package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class PersonalMuckatScheduleDTO {
    private final String scheduleId;
    private final String personalMuckatId;
    private final String restaurantId;
    private final LocalDate timestamp;

}
