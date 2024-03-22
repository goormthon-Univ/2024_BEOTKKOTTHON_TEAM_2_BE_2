package muckkitlist_spring.muckkitlist_spring.repository;

import muckkitlist_spring.muckkitlist_spring.entity.MuckatScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MuckatScheduleRepository extends JpaRepository<MuckatScheduleEntity, String> {
    @Query("SELECT s FROM MuckatScheduleEntity s WHERE s.muckatListEntity.muckatId = :muckatId")
    List<MuckatScheduleEntity> findByMuckatId(String muckatId);

}
