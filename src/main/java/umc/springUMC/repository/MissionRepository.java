package umc.springUMC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springUMC.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
