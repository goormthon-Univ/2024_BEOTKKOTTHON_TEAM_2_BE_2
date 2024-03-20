package muckkitlist_spring.muckkitlist_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import muckkitlist_spring.muckkitlist_spring.entity.MemoEntity;

@Repository
public interface MemoRepository extends JpaRepository<MemoEntity, String> {
    @Query("SELECT m FROM MemoEntity m WHERE m.muckatlistId = :muckatListId")
    MemoEntity findByMuckatListId(@Param("muckatListId") String muckatListId);
}
