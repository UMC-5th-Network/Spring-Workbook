package umc.springUMC.service.MemberService;

import umc.springUMC.domain.Member;
import umc.springUMC.web.dto.MemberRequestDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);
}
