package muckkitlist_spring.muckkitlist_spring.service;

import muckkitlist_spring.muckkitlist_spring.entity.PersonalMuckatScheduleEntity;
import muckkitlist_spring.muckkitlist_spring.repository.GroupMuckatListRepository;
import muckkitlist_spring.muckkitlist_spring.repository.PersonalMuckatScheduleRepository;
import muckkitlist_spring.muckkitlist_spring.repository.RestaurantInfoRepository;
import muckkitlist_spring.muckkitlist_spring.repository.UserInfoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersonalMuckatScheduleService {

    private final PersonalMuckatScheduleRepository scheduleRepository;
    private final RestaurantInfoRepository restaurantInfoRepository;
    private final GroupMuckatListRepository groupMuckatListRepository;
    private final UserInfoRepository userInfoRepository;

    public PersonalMuckatScheduleService(PersonalMuckatScheduleRepository scheduleRepository, RestaurantInfoRepository restaurantInfoRepository, GroupMuckatListRepository groupMuckatListRepository, UserInfoRepository userInfoRepository) {
        this.scheduleRepository = scheduleRepository;
        this.restaurantInfoRepository = restaurantInfoRepository;
        this.groupMuckatListRepository = groupMuckatListRepository;
        this.userInfoRepository = userInfoRepository;
    }

    // 개인 먹잇감 스케줄 추가
    public PersonalMuckatScheduleEntity addSchedule(PersonalMuckatScheduleEntity schedule) {
        return scheduleRepository.save(schedule);
    }
    // 개인 먹잇감 스케줄 삭제
    public void deleteSchedule(String scheduleId) {
        scheduleRepository.deleteById(scheduleId);
    }
    // 특정 사용자의 모든 개인 먹잇감 스케줄 조회
}
