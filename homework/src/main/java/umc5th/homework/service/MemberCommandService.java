package umc5th.homework.service;

import umc5th.homework.domain.Member;
import umc5th.homework.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    public Member joinMember(MemberRequestDTO.JoinDto request);
}
