package muckkitlist_spring.muckkitlist_spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import muckkitlist_spring.muckkitlist_spring.dto.MemoDTO;
import muckkitlist_spring.muckkitlist_spring.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memos")
public class MemoController {

    private final MemoService memoService;

    @Autowired
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping
    @Operation(summary = "모든 메모 조회", description = "모든 메모 정보를 조회합니다.")
    public ResponseEntity<List<MemoDTO>> getAllMemos() {
        List<MemoDTO> memoDTOs = memoService.getAllMemos();
        return ResponseEntity.ok(memoDTOs);
    }

    @GetMapping("/{memoId}")
    @Operation(summary = "메모 조회", description = "특정 메모의 정보를 먹킷리스트id로 조회합니다.")
    public ResponseEntity<MemoDTO> getMemoById(@PathVariable String muckatListId) {
        MemoDTO memoDTO = memoService.getMemoById(muckatListId);
        return memoDTO != null ?
                ResponseEntity.ok(memoDTO) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "메모 생성", description = "새로운 메모를 생성합니다.")
    public ResponseEntity<MemoDTO> createMemo(@RequestParam String muckatlistId, @RequestParam String restaurantId, @RequestParam boolean group) {
        MemoDTO createdMemoDTO = memoService.createMemo(muckatlistId, restaurantId, group);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMemoDTO);
    }
/*
    @PutMapping("/{memoId}")
    @Operation(summary = "메모 수정", description = "특정 메모의 정보를 수정합니다.")
    public ResponseEntity<MemoDTO> updateMemo(@PathVariable String memoId, @RequestBody MemoDTO memoDTO) {
        MemoDTO updatedMemoDTO = memoService.updateMemo(memoId, memoDTO);
        return ResponseEntity.ok(updatedMemoDTO);
    }
*/
    @DeleteMapping("/{memoId}")
    @Operation(summary = "메모 삭제", description = "특정 메모를 삭제합니다.")
    public ResponseEntity<Void> deleteMemo(@PathVariable String memoId) {
        memoService.deleteMemo(memoId);
        return ResponseEntity.noContent().build();
    }
}
