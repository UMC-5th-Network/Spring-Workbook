package umc.springUMC.converter;

import umc.springUMC.domain.Member;
import umc.springUMC.domain.Mission;
import umc.springUMC.domain.enums.MissionStatus;
import umc.springUMC.domain.mapping.MemberMission;
import umc.springUMC.web.dto.MemberMissionRequestDTO;
import umc.springUMC.web.dto.MemberMissionResponseDTO;

import java.time.LocalDateTime;

public class MemberMissionConverter {

    public static MemberMissionResponseDTO.AddMMResultDTO toMMResultDTO(MemberMission memberMission) {

        return MemberMissionResponseDTO.AddMMResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(MemberMissionRequestDTO.AddMMDTO request, Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }
}
