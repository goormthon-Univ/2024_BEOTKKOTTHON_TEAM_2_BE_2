package muckkitlist_spring.muckkitlist_spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import muckkitlist_spring.muckkitlist_spring.dto.PersonalMuckatMemoDTO;
import muckkitlist_spring.muckkitlist_spring.service.PersonalMuckatMemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personal-muckat-memos")
@Tag(name = "MuckatMemo", description = "매핑테이블 관련 API, 머킷리스트와 레스토랑 정보를 통하여 매핑테이블 생성")
public class MuckatMemoController {

    private final PersonalMuckatMemoService personalMuckatMemoService;

    @Autowired
    public MuckatMemoController(PersonalMuckatMemoService personalMuckatMemoService) {
        this.personalMuckatMemoService = personalMuckatMemoService;
    }

    @PostMapping("/create")
    @Operation(description = "메모장 생성")
    public ResponseEntity<PersonalMuckatMemoDTO> createPersonalMuckatMemo(@RequestBody PersonalMuckatMemoDTO personalMuckatMemoDTO) {
        PersonalMuckatMemoDTO createdMemo = personalMuckatMemoService.createPersonalMuckatMemo(personalMuckatMemoDTO);
        return new ResponseEntity<>(createdMemo, HttpStatus.CREATED);
    }

    @GetMapping("/search/{muckatListId}")
    @Operation(description = "먹킷리스트 아이디로 검색하기")
    public ResponseEntity<List<PersonalMuckatMemoDTO>> getMemosByMuckatId(@RequestParam String muckatListId) {
        List<PersonalMuckatMemoDTO> memos = personalMuckatMemoService.getMemosByDTO(muckatListId);
        return ResponseEntity.ok(memos);
    }

    @PostMapping("/search/checkUpdate")
    @Operation(description = "먹킷 리스트 아이디와 식당 아이디로 검색하여 해당하는 메모장의 체크 여부 수정 ")
    public ResponseEntity<PersonalMuckatMemoDTO> getMemoAndSetCheck(@RequestBody PersonalMuckatMemoDTO personalMuckatMemoDTO) {
        PersonalMuckatMemoDTO memoWithCheck = personalMuckatMemoService.getMemosByDTOAndCheck(personalMuckatMemoDTO);
        return ResponseEntity.ok(memoWithCheck);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deletePersonalMuckatMemo(@RequestBody PersonalMuckatMemoDTO personalMuckatMemoDTO) {
        personalMuckatMemoService.deletePersonalMuckatMemo(personalMuckatMemoDTO);
        return ResponseEntity.noContent().build();
    }
}
