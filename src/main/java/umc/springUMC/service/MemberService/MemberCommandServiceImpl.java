package umc.springUMC.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.springUMC.domain.Member;
import umc.springUMC.repository.MemberRepository;
import umc.springUMC.web.dto.MemberRequestDTO;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    @Override
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        return null;
    }
}
