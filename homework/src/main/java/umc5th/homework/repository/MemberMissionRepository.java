package umc5th.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc5th.homework.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}
