package muckkitlist_spring.muckkitlist_spring.service;

import muckkitlist_spring.muckkitlist_spring.dto.MemoDTO;
import muckkitlist_spring.muckkitlist_spring.entity.MemoEntity;
import muckkitlist_spring.muckkitlist_spring.entity.RestaurantInfoEntity;
import muckkitlist_spring.muckkitlist_spring.entity.UserInfoEntity;
import muckkitlist_spring.muckkitlist_spring.repository.MemoRepository;
import muckkitlist_spring.muckkitlist_spring.repository.RestaurantInfoRepository;
import muckkitlist_spring.muckkitlist_spring.utility.MemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemoService {

    private final MemoRepository memoRepository;
    private final MemoMapper memoMapper;
    private final RestaurantInfoRepository restaurantInfoRepository;

    @Autowired
    public MemoService(MemoRepository memoRepository, MemoMapper memoMapper, RestaurantInfoRepository restaurantInfoRepository) {
        this.memoRepository = memoRepository;
        this.memoMapper = memoMapper;
        this.restaurantInfoRepository = restaurantInfoRepository;
    }

    public List<MemoDTO> getAllMemos() {
        List<MemoEntity> memoEntities = memoRepository.findAll();
        return memoEntities.stream()
                .map(memoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MemoDTO getMemoById(String muckatlistId) {
        return memoRepository.findById(muckatlistId)
                .map(memoMapper::toDTO)
                .orElse(null);
    }

    public MemoDTO createMemo(String muckatlistId, String restaurantId, boolean group) {

        Optional<RestaurantInfoEntity> restaurantInfoEntityOptional= restaurantInfoRepository.findById(restaurantId);
        if(restaurantInfoEntityOptional.isPresent()){
            RestaurantInfoEntity restaurantInfoEntity=restaurantInfoEntityOptional.get();
            MemoEntity memoEntity=new MemoEntity();
            memoEntity.setMuckatListId(muckatlistId);
            memoEntity.setRestaurantId(restaurantInfoEntityOptional.get());
            memoEntity.setIsChecked(false);
            memoEntity.setIsGroup(group);

            // MemoDTO를 MemoEntity로 변환
            MemoDTO memoDTO = memoMapper.toDTO(memoEntity);

            // MemoEntity 저장
            MemoEntity savedMemoEntity = memoRepository.save(memoEntity);

            // 저장된 MemoEntity를 MemoDTO로 변환하여 반환
            return memoMapper.toDTO(savedMemoEntity);
        }
        // MemoDTO 생성
        else {
            // 사용자 정보 또는 음식점 정보가 없는 경우에는 예외 처리
            throw new IllegalArgumentException("not found");
        }
    }

/*
    public MemoDTO updateMemo(String memoId, MemoDTO memoDTO) {
        MemoEntity existingMemoEntity = memoRepository.findById(memoId)
                .orElseThrow(() -> new IllegalArgumentException("Memo not found with ID: " + memoId));

        // Update existing memo entity
        existingMemoEntity.setMuckatlistId(memoDTO.getMuckatlistId());
        existingMemoEntity.setRestaurant(memoDTO.getRestaurant());
        existingMemoEntity.setCheck(memoDTO.isCheck());
        existingMemoEntity.setIsGroup(memoDTO.getIsGroup());

        // Save updated memo entity
        MemoEntity updatedMemoEntity = memoRepository.save(existingMemoEntity);
        return memoMapper.toDTO(updatedMemoEntity);
    }
*/
    public void deleteMemo(String memoId) {
        memoRepository.deleteById(memoId);
    }
}
