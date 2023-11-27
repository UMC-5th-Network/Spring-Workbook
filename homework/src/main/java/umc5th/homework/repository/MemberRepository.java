package umc5th.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc5th.homework.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
