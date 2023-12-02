package umc.springUMC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springUMC.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
