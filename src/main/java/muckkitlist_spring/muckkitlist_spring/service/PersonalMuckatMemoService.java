package muckkitlist_spring.muckkitlist_spring.service;

import muckkitlist_spring.muckkitlist_spring.dto.PersonalMuckatMemoDTO;
import muckkitlist_spring.muckkitlist_spring.entity.MuckatListEntity;
//import muckkitlist_spring.muckkitlist_spring.entity.MuckatMemoEntity;
import muckkitlist_spring.muckkitlist_spring.entity.MuckatMemoEntity;
import muckkitlist_spring.muckkitlist_spring.entity.RestaurantInfoEntity;
import muckkitlist_spring.muckkitlist_spring.repository.MuckatMemoRepository;
import muckkitlist_spring.muckkitlist_spring.repository.MuckatListRepository;
import muckkitlist_spring.muckkitlist_spring.repository.RestaurantInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonalMuckatMemoService {

    private final MuckatMemoRepository personalMuckatMemoRepository;
    private final MuckatListRepository muckatListRepository;
    private final RestaurantInfoRepository restaurantInfoRepository;

    @Autowired
    public PersonalMuckatMemoService(MuckatMemoRepository personalMuckatMemoRepository,
                                     MuckatListRepository muckatListRepository,
                                     RestaurantInfoRepository restaurantInfoRepository) {
        this.personalMuckatMemoRepository = personalMuckatMemoRepository;
        this.muckatListRepository = muckatListRepository;
        this.restaurantInfoRepository = restaurantInfoRepository;
    }

    public PersonalMuckatMemoDTO createPersonalMuckatMemo(PersonalMuckatMemoDTO personalMuckatMemoDto) {
        Optional<RestaurantInfoEntity> restaurantInfoEntity = restaurantInfoRepository.findById(personalMuckatMemoDto.getRestaurantId());
        Optional<MuckatListEntity> personalMuckatListEntity = muckatListRepository.findById(personalMuckatMemoDto.getPersonalMuckatId());

        if (restaurantInfoEntity.isPresent() && personalMuckatListEntity.isPresent()) {
            RestaurantInfoEntity restaurant = restaurantInfoEntity.get();
            MuckatListEntity muckatList = personalMuckatListEntity.get();

            MuckatMemoEntity memo = new MuckatMemoEntity();
            memo.setRestaurantInfoEntity(restaurant);
            memo.setMuckatListEntity(muckatList);
            memo.setIsCheck(false);
            personalMuckatMemoRepository.save(memo);

            return new PersonalMuckatMemoDTO(restaurant.getRestaurantId(), muckatList.getMuckatId().toString(),false);
        }
        return null;
    }

    public List<PersonalMuckatMemoDTO> getMemosByDTO(String muckatListId) {
        Optional<MuckatListEntity> muckatListEntityOptional = muckatListRepository.findById(muckatListId);
        if (muckatListEntityOptional.isPresent()) {
            MuckatListEntity muckatListEntity = muckatListEntityOptional.get();
            List<MuckatMemoEntity> memos = personalMuckatMemoRepository.findByMuckatListEntity(muckatListEntity);

            // MuckatMemoEntity를 PersonalMuckatMemoDTO로 변환하여 리스트에 추가
            List<PersonalMuckatMemoDTO> memoDTOs = new ArrayList<>();
            for (MuckatMemoEntity memoEntity : memos) {
                PersonalMuckatMemoDTO memoDTO = new PersonalMuckatMemoDTO(
                        memoEntity.getRestaurantInfoEntity().getRestaurantId(),
                        muckatListId,
                        memoEntity.isCheck()
                );
                memoDTOs.add(memoDTO);
            }

            return memoDTOs;
        } else {
            throw new NotFoundException("MuckatListEntity not found with id: " + muckatListId);
        }
    }


    public PersonalMuckatMemoDTO getMemosByDTOAndCheck(PersonalMuckatMemoDTO personalMuckatMemoDTO) {
        Optional<MuckatListEntity> muckatListEntity = muckatListRepository.findById(personalMuckatMemoDTO.getPersonalMuckatId());
        if (muckatListEntity.isPresent()) {
            List<MuckatMemoEntity> memos = personalMuckatMemoRepository.findByMuckatListEntity(muckatListEntity.get());
            Optional<MuckatMemoEntity> selectedMemo = memos.stream()
                    .filter(memo -> memo.getRestaurantInfoEntity().getRestaurantId().equals(personalMuckatMemoDTO.getRestaurantId()))
                    .findFirst();

            if (selectedMemo.isPresent()) {
                // PersonalMuckatMemoDTO로 변환하여 반환
                Optional<RestaurantInfoEntity> restaurantInfoEntity = restaurantInfoRepository.findById(personalMuckatMemoDTO.getRestaurantId());
                Optional<MuckatListEntity> personalMuckatListEntity = muckatListRepository.findById(personalMuckatMemoDTO.getPersonalMuckatId());
                MuckatMemoEntity muckatMemoEntity=new MuckatMemoEntity();
                muckatMemoEntity.setRestaurantInfoEntity(restaurantInfoEntity.get());
                muckatMemoEntity.setMuckatListEntity(personalMuckatListEntity.get());
                muckatMemoEntity.setIsCheck(personalMuckatMemoDTO.isCheck());
                personalMuckatMemoRepository.save(muckatMemoEntity);

                return new PersonalMuckatMemoDTO(muckatMemoEntity.getRestaurantInfoEntity().getRestaurantId(), muckatMemoEntity.getMuckatListEntity().getMuckatId(),muckatMemoEntity.getChecks());

            } else {
                // 해당하는 메모가 없는 경우 null 반환
                return null;
            }
        } else {
            // personalMuckatId에 해당하는 PersonalMuckatListEntity가 없는 경우 예외처리
            throw new NotFoundException("PersonalMuckatListEntity not found with id: " + personalMuckatMemoDTO.getPersonalMuckatId());
        }
    }








    public void deletePersonalMuckatMemo(PersonalMuckatMemoDTO personalMuckatMemoDto) {
        Optional<RestaurantInfoEntity> restaurantInfoEntity = restaurantInfoRepository.findById(personalMuckatMemoDto.getRestaurantId());
        Optional<MuckatListEntity> personalMuckatListEntity = muckatListRepository.findById(personalMuckatMemoDto.getPersonalMuckatId());

        if (restaurantInfoEntity.isPresent() && personalMuckatListEntity.isPresent()) {
            Optional<MuckatMemoEntity> memoToDelete = personalMuckatMemoRepository.findByRestaurantInfoEntityAndMuckatListEntity(
                    personalMuckatListEntity.get(),restaurantInfoEntity.get());

            memoToDelete.ifPresent(personalMuckatMemoRepository::delete);
        }
    }
}
