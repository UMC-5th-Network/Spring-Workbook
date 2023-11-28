package umc5th.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc5th.homework.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
