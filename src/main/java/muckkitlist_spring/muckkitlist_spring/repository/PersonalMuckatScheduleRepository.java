package muckkitlist_spring.muckkitlist_spring.repository;

import muckkitlist_spring.muckkitlist_spring.entity.PersonalMuckatScheduleEntity;
import muckkitlist_spring.muckkitlist_spring.entity.RestaurantInfoEntity;
import muckkitlist_spring.muckkitlist_spring.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PersonalMuckatScheduleRepository extends JpaRepository<PersonalMuckatScheduleEntity, String> {

    @Query("SELECT p FROM PersonalMuckatScheduleEntity p WHERE p.personalMuckatListEntity.kakaoId = :kakaoId")
    List<PersonalMuckatScheduleEntity> findAllPersonalIncludeUserId(@Param("kakaoId") UserInfoEntity kakaoId);
}
