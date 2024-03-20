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
            System.out.println(group);
            memoEntity.setGroup(group);

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

    public MemoDTO updateMemo(String muckatlistId, boolean check) {
            // 해당 레스토랑 정보가 존재하는 경우에만 메모 엔터티를 업데이트합니다.
            // 해당 muckatlistId에 해당하는 메모 엔터티를 가져옵니다.
            Optional<MemoEntity> memoEntityOptional = Optional.ofNullable(memoRepository.findByMuckatListId(muckatlistId));
            if (memoEntityOptional.isPresent()) {
                // 메모 엔터티가 존재하는 경우에만 업데이트합니다.
                MemoEntity memoEntity = memoEntityOptional.get();
                // 업데이트할 내용 설정
                memoEntity.setIsChecked(check);
                // MemoEntity 저장
                MemoEntity updatedMemoEntity = memoRepository.save(memoEntity);
                // 업데이트된 MemoEntity를 MemoDTO로 변환하여 반환
                return memoMapper.toDTO(updatedMemoEntity);
            } else {
                // 해당 muckatlistId에 해당하는 메모가 없는 경우에는 예외 처리
                throw new IllegalArgumentException("Memo not found for muckatlistId: " + muckatlistId);
            }
        }

    public void deleteMemo(String memoId) {
        memoRepository.deleteById(memoId);
    }

    public MemoDTO getMemoByMuckatListId(String muckatListId) {
        MemoEntity memoEntity= memoRepository.findByMuckatListId(muckatListId);
        return memoMapper.toDTO(memoEntity);
    }
}
