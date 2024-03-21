package muckkitlist_spring.muckkitlist_spring.repository;

import muckkitlist_spring.muckkitlist_spring.entity.PersonalMuckatListEntity;
import muckkitlist_spring.muckkitlist_spring.entity.PersonalMuckatMemo;
import muckkitlist_spring.muckkitlist_spring.entity.RestaurantInfoEntity;
import muckkitlist_spring.muckkitlist_spring.utility.PersonalMuckatMemoComposite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonalMuckatMemoRepository extends JpaRepository<PersonalMuckatMemo, PersonalMuckatMemoComposite> {
    List<PersonalMuckatMemo> findByPersonalMuckatListEntity(PersonalMuckatListEntity personalMuckatListEntity);

    List<PersonalMuckatMemo> findByRestaurantInfoEntity(RestaurantInfoEntity restaurantInfoEntity);

    Optional<PersonalMuckatMemo> findByRestaurantInfoEntityAndPersonalMuckatListEntity(RestaurantInfoEntity restaurantInfoEntity, PersonalMuckatListEntity personalMuckatListEntity);
    // PersonalMuckatMemo 엔티티와 관련된 추가 메서드가 있다면 여기에 선언
}
