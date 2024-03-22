package muckkitlist_spring.muckkitlist_spring.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import muckkitlist_spring.muckkitlist_spring.dto.PersonalMuckatMemoDTO;
import muckkitlist_spring.muckkitlist_spring.service.PersonalMuckatMemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personal-muckat-memos")
@Tag(name = "MuckatMemo", description = "매핑테이블 관련 API,머킷리스트와 레스토랑 정보를 통하여 매핑테이블 생성")

public class MuckatMemoController {

    private final PersonalMuckatMemoService personalMuckatMemoService;

    @Autowired
    public MuckatMemoController(PersonalMuckatMemoService personalMuckatMemoService) {
        this.personalMuckatMemoService = personalMuckatMemoService;
    }

    @PostMapping("/create")
    public PersonalMuckatMemoDTO createPersonalMuckatMemo(@RequestBody PersonalMuckatMemoDTO personalMuckatMemoDTO) {
        return personalMuckatMemoService.createPersonalMuckatMemo(personalMuckatMemoDTO);
    }

    @GetMapping("/search")
    public PersonalMuckatMemoDTO getMemosByRestaurant(@RequestParam PersonalMuckatMemoDTO personalMuckatMemoDTO) {
        return personalMuckatMemoService.getMemosByDTO(personalMuckatMemoDTO);
    }


    @PostMapping("/search/checkUpdate")
    public PersonalMuckatMemoDTO getMemoAndSetCheck(@RequestParam PersonalMuckatMemoDTO personalMuckatMemoDTO) {
        return personalMuckatMemoService.getMemosByDTOAndCheck(personalMuckatMemoDTO);
    }


    @DeleteMapping("/delete")
    public void deletePersonalMuckatMemo(@RequestBody PersonalMuckatMemoDTO personalMuckatMemoDTO) {
        personalMuckatMemoService.deletePersonalMuckatMemo(personalMuckatMemoDTO);
    }
}
