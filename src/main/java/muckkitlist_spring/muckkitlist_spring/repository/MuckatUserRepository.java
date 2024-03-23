package muckkitlist_spring.muckkitlist_spring.repository;

import muckkitlist_spring.muckkitlist_spring.entity.MuckatUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuckatUserRepository extends JpaRepository<MuckatUserEntity,String> {
}
