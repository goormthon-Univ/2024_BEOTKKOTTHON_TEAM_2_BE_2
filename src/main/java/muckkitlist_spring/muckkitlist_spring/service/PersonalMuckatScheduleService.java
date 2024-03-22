package muckkitlist_spring.muckkitlist_spring.service;

import muckkitlist_spring.muckkitlist_spring.dto.PersonalMuckatScheduleDTO;
import muckkitlist_spring.muckkitlist_spring.entity.MuckatListEntity;
import muckkitlist_spring.muckkitlist_spring.entity.MuckatScheduleEntity;

import muckkitlist_spring.muckkitlist_spring.entity.RestaurantInfoEntity;
import muckkitlist_spring.muckkitlist_spring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonalMuckatScheduleService {

    private final MuckatScheduleRepository scheduleRepository;
    private final RestaurantInfoRepository restaurantInfoRepository;
    private final UserInfoRepository userInfoRepository;
    private final MuckatListRepository muckatListRepository;
    @Autowired
    public PersonalMuckatScheduleService(MuckatScheduleRepository scheduleRepository, RestaurantInfoRepository restaurantInfoRepository,UserInfoRepository userInfoRepository,
                                         MuckatListRepository muckatListRepository) {
        this.scheduleRepository = scheduleRepository;
        this.restaurantInfoRepository = restaurantInfoRepository;
        this.userInfoRepository = userInfoRepository;
        this.muckatListRepository = muckatListRepository;
    }

    // 개인 먹잇감 스케줄 등록
    public PersonalMuckatScheduleDTO createSchedule(PersonalMuckatScheduleDTO personalMuckatScheduleDTO) {
        Optional<MuckatListEntity> muckatListEntity= muckatListRepository.findById(personalMuckatScheduleDTO.getPersonalMuckatId()) ;
        Optional<RestaurantInfoEntity> restaurantInfoEntity=restaurantInfoRepository.findById(personalMuckatScheduleDTO.getRestaurantId());
        MuckatScheduleEntity muckatScheduleEntity=new MuckatScheduleEntity();
        UUID uuid4 = UUID.randomUUID();
        muckatScheduleEntity.setScheduleId(uuid4.toString());
        muckatScheduleEntity.setRestaurantEntity(restaurantInfoEntity.get());
        muckatScheduleEntity.setPersonalMuckatList(muckatListEntity.get());
        muckatScheduleEntity.setTimeStamp(personalMuckatScheduleDTO.getTimestamp());
        scheduleRepository.save(muckatScheduleEntity);
        return new PersonalMuckatScheduleDTO(muckatScheduleEntity.getScheduleId(), muckatListEntity.get().getMuckatId().toString(),restaurantInfoEntity.get().getRestaurantId(),muckatScheduleEntity.getTimestamp());
    }
    // 개인 먹잇감 스케줄 삭제
    public PersonalMuckatScheduleDTO updateSchedule(PersonalMuckatScheduleDTO personalMuckatScheduleDTO) {
        // 스케쥴을 찾습니다.
        Optional<MuckatScheduleEntity> optionalMuckatScheduleEntity = scheduleRepository.findById(personalMuckatScheduleDTO.getScheduleId());

        // 스케쥴이 존재하는지 확인합니다.
        if (optionalMuckatScheduleEntity.isPresent()) {
            MuckatScheduleEntity muckatScheduleEntity = optionalMuckatScheduleEntity.get();

            // 새로운 정보로 업데이트합니다.
            Optional<MuckatListEntity> muckatListEntity = muckatListRepository.findById(personalMuckatScheduleDTO.getPersonalMuckatId());
            Optional<RestaurantInfoEntity> restaurantInfoEntity = restaurantInfoRepository.findById(personalMuckatScheduleDTO.getRestaurantId());

            muckatScheduleEntity.setRestaurantEntity(restaurantInfoEntity.get());
            muckatScheduleEntity.setPersonalMuckatList(muckatListEntity.get());
            muckatScheduleEntity.setTimeStamp(personalMuckatScheduleDTO.getTimestamp());
            // 업데이트된 스케쥴을 저장합니다.
            MuckatScheduleEntity updatedScheduleEntity = scheduleRepository.save(muckatScheduleEntity);

            // 업데이트된 정보를 반환합니다.
            return new PersonalMuckatScheduleDTO(
                    updatedScheduleEntity.getScheduleId(),
                    updatedScheduleEntity.getMuckatListEntity().getMuckatId(),
                    updatedScheduleEntity.getRestaurantInfoEntity().getRestaurantId(),
                    muckatScheduleEntity.getTimestamp()
            );
        } else {
            // 스케쥴을 찾을 수 없을 때 예외처리
            throw new NotFoundException("스케쥴을 찾을 수 없습니다. ID: " + personalMuckatScheduleDTO.getScheduleId());
        }
    }




//스케줄 삭제-스케줄의 아이디 값으로

    public void deleteSchedule(String scheduleId) {
        scheduleRepository.deleteById(scheduleId);
    }

}
