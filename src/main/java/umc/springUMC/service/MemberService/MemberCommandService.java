package umc.springUMC.service.MemberService;

import org.springframework.data.domain.Page;
import umc.springUMC.domain.Member;
import umc.springUMC.domain.Review;
import umc.springUMC.web.dto.MemberRequestDTO;

import java.util.List;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);

    Page<Review> getReviewList(Long memberId, Integer page);

    boolean existMember(List<Long> value);
}
