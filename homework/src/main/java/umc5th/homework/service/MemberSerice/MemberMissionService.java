package umc5th.homework.service.MemberSerice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.homework.converter.MemberMissionConverter;
import umc5th.homework.domain.Member;
import umc5th.homework.domain.Mission;
import umc5th.homework.domain.enums.MissionStatus;
import umc5th.homework.domain.mapping.MemberMission;
import umc5th.homework.repository.MemberMissionRepository;
import umc5th.homework.repository.MemberRepository;
import umc5th.homework.repository.MissionRepository;
import umc5th.homework.web.dto.MemberMissionDTO;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MemberMissionService {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;


    @Transactional
    public MemberMission addMemberMission(MemberMissionDTO.AddMemberMissionDTO requestDTO){
        Optional<Member> member = memberRepository.findById(requestDTO.getMemberId());
        Optional<Mission> mission = missionRepository.findById(requestDTO.getMissionId());

        if(member.isEmpty() || mission.isEmpty()){
            log.info("member: {}", member);
            log.info("mission: {}", mission);
            new IllegalArgumentException("없는 member 혹은 mission");
        }


        MemberMission memberMission = MemberMissionConverter.toMemberMission(member.get(), mission.get());
        memberMissionRepository.save(memberMission);
        return  memberMission;
    }


    public Page<MemberMission> searchMemberMission(Long memberId, MissionStatus missionStatus, Integer page){
        Member member = memberRepository.findById(memberId).get();
        Page<MemberMission> memberMissionPage = memberMissionRepository.findAllByMemberAndStatus(member, missionStatus, PageRequest.of(page, 10));

        return memberMissionPage;
    }

    @Transactional
    public Long saveComplete(Long memberMissionId){
        MemberMission memberMission = memberMissionRepository.findById(memberMissionId).get();
        memberMission.setStatus(MissionStatus.COMPLETE);
        return  memberMissionId;
    }
}
