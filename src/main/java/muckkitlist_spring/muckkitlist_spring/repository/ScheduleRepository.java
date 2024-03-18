package muckkitlist_spring.muckkitlist_spring.repository;


import muckkitlist_spring.muckkitlist_spring.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import muckkitlist_spring.muckkitlist_spring.entity.RestaurantInfoEntity;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity, String> {
  // 추가적인 메서드 정의가 필요한 경우 여기에 추가할 수 있습니다.
}
