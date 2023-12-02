package umc.springUMC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springUMC.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}
