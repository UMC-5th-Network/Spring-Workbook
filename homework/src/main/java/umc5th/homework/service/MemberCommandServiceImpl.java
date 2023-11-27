package umc5th.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc5th.homework.converter.MemberConverter;
import umc5th.homework.domain.Member;
import umc5th.homework.repository.MemberRepository;
import umc5th.homework.web.dto.MemberRequestDTO;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {
    private final MemberRepository memberRepository;

    @Override
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Member member = MemberConverter.toMember(request);
        return null;
    }
}
