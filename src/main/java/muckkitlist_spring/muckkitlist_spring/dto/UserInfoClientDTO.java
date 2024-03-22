package muckkitlist_spring.muckkitlist_spring.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserInfoClientDTO {
    private final String kakaoId;
    private final String userId;
    private final String universityName; // 대학 정보 DTO로 변경
    private final String fcmToken;
    public static UserInfoDTO fromUserInfoClientDTO(UserInfoClientDTO clientDTO) {
        return new UserInfoDTO(
                clientDTO.getKakaoId(),
                clientDTO.getUserId(),
                new UniversityInfoDTO(
                        clientDTO.getUniversityName(),
                        null, // address 정보는 제공하지 않음
                        0.0, // positionX 정보는 제공하지 않음
                        0.0 // positionY 정보는 제공하지 않음
                ),
                clientDTO.getFcmToken()
        );
    }


}
