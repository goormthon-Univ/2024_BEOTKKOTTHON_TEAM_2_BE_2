package muckkitlist_spring.muckkitlist_spring.repository;

import muckkitlist_spring.muckkitlist_spring.entity.MuckatListEntity;
import muckkitlist_spring.muckkitlist_spring.entity.MuckatMemoEntity;

import muckkitlist_spring.muckkitlist_spring.entity.RestaurantInfoEntity;
import muckkitlist_spring.muckkitlist_spring.utility.MuckatMemoComposite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MuckatMemoRepository extends JpaRepository<MuckatMemoEntity, MuckatMemoComposite> {
    //List<MuckatMemoEntity> findByPersonalMuckatListEntity(MuckatMemoEntity muckatMemoEntity);

   // List<MuckatMemoEntity> findByRestaurantInfoEntity(RestaurantInfoEntity restaurantInfoEntity);


    List<MuckatMemoEntity> findByMuckatListEntity(MuckatListEntity muckatListEntity);

    Optional<MuckatMemoEntity> findByRestaurantInfoEntityAndMuckatListEntity(MuckatListEntity muckatListEntity,RestaurantInfoEntity restaurantInfoEntity);
    // PersonalMuckatMemo 엔티티와 관련된 추가 메서드가 있다면 여기에 선언
}
