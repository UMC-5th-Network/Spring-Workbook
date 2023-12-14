package umc5th.homework.service.MemberSerice;

import org.springframework.data.domain.Page;
import umc5th.homework.domain.Member;
import umc5th.homework.domain.Review;

import java.util.Optional;

public interface MemberService {
    Optional<Member> findMember(Long id);

    Page<Review> getReviewList(Long memberId, Integer page);
}
