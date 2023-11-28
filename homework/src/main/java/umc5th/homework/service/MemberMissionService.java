package umc5th.homework.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.homework.converter.MemberMissionConverter;
import umc5th.homework.domain.Member;
import umc5th.homework.domain.Mission;
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
}
