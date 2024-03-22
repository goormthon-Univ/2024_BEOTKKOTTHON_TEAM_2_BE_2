package muckkitlist_spring.muckkitlist_spring.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import muckkitlist_spring.muckkitlist_spring.dto.PersonalMuckatScheduleDTO;
import muckkitlist_spring.muckkitlist_spring.service.PersonalMuckatScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
@Tag(name = "Schedule", description = "스케줄 관련 API")

public class MuckatScheduleController {

    private final PersonalMuckatScheduleService scheduleService;

    @Autowired
    public MuckatScheduleController(PersonalMuckatScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // 개인 먹잇감 스케줄 등록
    @PostMapping("/create")
    @Operation(summary = "스케쥴 생성", description = "스케줄을 생성합니다.필요 데이터:스케줄 아이디,머킷리스트 아이디,식당 아이디,날짜")

    public ResponseEntity<PersonalMuckatScheduleDTO> addSchedule(@RequestBody PersonalMuckatScheduleDTO schedule) {
        PersonalMuckatScheduleDTO savedSchedule = scheduleService.createSchedule(schedule);
        return new ResponseEntity<>(savedSchedule, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    @Operation(summary = "업데이트", description = "특정 스케줄을 업데이트합니다.필요 데이터:스케줄 아이디,식당 아이디" +
            " 날짜.")
    public ResponseEntity<PersonalMuckatScheduleDTO> updateSchedule(@RequestBody PersonalMuckatScheduleDTO schedule) {
        PersonalMuckatScheduleDTO savedSchedule = scheduleService.updateSchedule(schedule);
        return new ResponseEntity<>(savedSchedule, HttpStatus.CREATED);
    }
    
    // 개인 먹잇감 스케줄 삭제
    @DeleteMapping("/delete/{scheduleId}")
    @Operation(summary = "삭제", description = "특정 스케줄id값에 해당하는 스케줄을 삭제합니다")

    public ResponseEntity<Void> deleteSchedule(@PathVariable String scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
