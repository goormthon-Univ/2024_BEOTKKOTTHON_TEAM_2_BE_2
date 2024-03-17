package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ScheduleDTO {
  private final String scheduleId;
  private final String restaurantId;
  private final long groupSchedule;
  private final String muckatlistId;
  private final String scheduleTime;

  // 생성자, Getter 메서드는 롬복 라이브러리를 통해 자동으로 생성됨
}
