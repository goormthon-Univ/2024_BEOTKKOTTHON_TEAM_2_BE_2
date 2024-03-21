package muckkitlist_spring.muckkitlist_spring.controller;

import muckkitlist_spring.muckkitlist_spring.dto.PersonalMuckatMemoDTO;
import muckkitlist_spring.muckkitlist_spring.entity.PersonalMuckatListEntity;
import muckkitlist_spring.muckkitlist_spring.entity.PersonalMuckatMemo;
import muckkitlist_spring.muckkitlist_spring.entity.RestaurantInfoEntity;
import muckkitlist_spring.muckkitlist_spring.service.PersonalMuckatMemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personal-muckat-memos")
public class PersonalMuckatMemoController {

    private final PersonalMuckatMemoService personalMuckatMemoService;

    @Autowired
    public PersonalMuckatMemoController(PersonalMuckatMemoService personalMuckatMemoService) {
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

    @DeleteMapping("/delete")
    public void deletePersonalMuckatMemo(@RequestBody PersonalMuckatMemoDTO personalMuckatMemoDTO) {
        personalMuckatMemoService.deletePersonalMuckatMemo(personalMuckatMemoDTO);
    }
}
