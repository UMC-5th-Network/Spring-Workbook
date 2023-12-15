package umc5th.homework.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc5th.homework.domain.Member;
import umc5th.homework.domain.enums.MissionStatus;
import umc5th.homework.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    @Query("select m from MemberMission m where m.member = :member and m.status = :status")
    Page<MemberMission> findAllByMemberAndStatus(@Param("member") Member member,
                                                 @Param("status") MissionStatus status,
                                                 Pageable pageable);
}
