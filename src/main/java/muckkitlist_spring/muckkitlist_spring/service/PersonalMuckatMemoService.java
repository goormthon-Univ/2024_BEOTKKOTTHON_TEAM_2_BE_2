package muckkitlist_spring.muckkitlist_spring.service;

import muckkitlist_spring.muckkitlist_spring.dto.PersonalMuckatMemoDTO;
import muckkitlist_spring.muckkitlist_spring.entity.PersonalMuckatListEntity;
import muckkitlist_spring.muckkitlist_spring.entity.PersonalMuckatMemo;
import muckkitlist_spring.muckkitlist_spring.entity.RestaurantInfoEntity;
import muckkitlist_spring.muckkitlist_spring.repository.PersonalMuckatListRepository;
import muckkitlist_spring.muckkitlist_spring.repository.PersonalMuckatMemoRepository;
import muckkitlist_spring.muckkitlist_spring.repository.RestaurantInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonalMuckatMemoService {

    private final PersonalMuckatMemoRepository personalMuckatMemoRepository;
    private final PersonalMuckatListRepository personalMuckatListRepository;
    private final RestaurantInfoRepository restaurantInfoRepository;

    @Autowired
    public PersonalMuckatMemoService(PersonalMuckatMemoRepository personalMuckatMemoRepository,
                                     PersonalMuckatListRepository personalMuckatListRepository,
                                     RestaurantInfoRepository restaurantInfoRepository) {
        this.personalMuckatMemoRepository = personalMuckatMemoRepository;
        this.personalMuckatListRepository = personalMuckatListRepository;
        this.restaurantInfoRepository = restaurantInfoRepository;
    }

    public PersonalMuckatMemoDTO createPersonalMuckatMemo(PersonalMuckatMemoDTO personalMuckatMemoDto) {
        Optional<RestaurantInfoEntity> restaurantInfoEntity = restaurantInfoRepository.findById(personalMuckatMemoDto.getRestaurantId());
        Optional<PersonalMuckatListEntity> personalMuckatListEntity = personalMuckatListRepository.findById(personalMuckatMemoDto.getPersonalMuckatId());

        if (restaurantInfoEntity.isPresent() && personalMuckatListEntity.isPresent()) {
            RestaurantInfoEntity restaurant = restaurantInfoEntity.get();
            PersonalMuckatListEntity muckatList = personalMuckatListEntity.get();

            PersonalMuckatMemo memo = new PersonalMuckatMemo();
            memo.setRestaurantInfoEntity(restaurant);
            memo.setPersonalMuckatListEntity(muckatList);

            personalMuckatMemoRepository.save(memo);

            return new PersonalMuckatMemoDTO(restaurant.getRestaurantId(), muckatList.getPersonalMuckatId());
        }
        return null;
    }
/*
    public PersonalMuckatMemoDTO getMemosByPersonalMuckatListAnd(PersonalMuckatMemoDTO personalMuckatMemoDTO) {
        List<PersonalMuckatMemo> memos = personalMuckatMemoRepository.findByPersonalMuckatListEntity();
        return
    }
*/
    public void deletePersonalMuckatMemo(PersonalMuckatMemoDTO personalMuckatMemoDto) {
        Optional<RestaurantInfoEntity> restaurantInfoEntity = restaurantInfoRepository.findById(personalMuckatMemoDto.getRestaurantId());
        Optional<PersonalMuckatListEntity> personalMuckatListEntity = personalMuckatListRepository.findById(personalMuckatMemoDto.getPersonalMuckatId());

        if (restaurantInfoEntity.isPresent() && personalMuckatListEntity.isPresent()) {
            Optional<PersonalMuckatMemo> memoToDelete = personalMuckatMemoRepository.findByRestaurantInfoEntityAndPersonalMuckatListEntity(
                    restaurantInfoEntity.get(), personalMuckatListEntity.get());

            memoToDelete.ifPresent(personalMuckatMemoRepository::delete);
        }
    }
}
