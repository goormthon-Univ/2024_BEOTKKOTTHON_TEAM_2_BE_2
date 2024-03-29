package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class UniversityInfoDTO {
    private final String universityName;
    private final String address;
    private final double positionX;
    private final double positionY;


    // 생성자, Getter 메서드는 롬복 라이브러리를 통해 자동으로 생성됨
}
