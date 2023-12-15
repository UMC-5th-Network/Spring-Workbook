package umc5th.homework.converter;

import org.springframework.data.domain.Page;
import umc5th.homework.domain.Member;
import umc5th.homework.domain.Mission;
import umc5th.homework.domain.enums.MissionStatus;
import umc5th.homework.domain.mapping.MemberMission;
import umc5th.homework.web.dto.MemberMissionDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {
    public static MemberMission toMemberMission(Member member, Mission mission){
        MemberMission memberMission = MemberMission.builder()
                .status(MissionStatus.CHALLEGING)
                .build();

        memberMission.setMission(mission);
        memberMission.setMember(member);

        return memberMission;
    }

    public static MemberMissionDTO.MemberMissionPreViewDTO memberMissionPreViewDTO(MemberMission memberMission){
        return MemberMissionDTO.MemberMissionPreViewDTO.builder()
                .memberId(memberMission.getMember().getId())
                .storeName(memberMission.getMission().getStore().getName())
                .reward(memberMission.getMission().getReward())
                .deadline(memberMission.getMission().getDeadline())
                .updatedAt(memberMission.getUpdatedAt())
                .createdAt(memberMission.getCreatedAt())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .missionStatus(memberMission.getStatus())
                .build();
    }

    public static MemberMissionDTO.MemberMissionPreViewListDTO memberMissionPreViewListDTO(Page<MemberMission> memberMissionList){

        List<MemberMissionDTO.MemberMissionPreViewDTO> memberMissionPreViewDTOList = memberMissionList.stream()
                .map(MemberMissionConverter::memberMissionPreViewDTO).collect(Collectors.toList());

        return MemberMissionDTO.MemberMissionPreViewListDTO.builder()
                .isLast(memberMissionList.isLast())
                .isFirst(memberMissionList.isFirst())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .listSize(memberMissionPreViewDTOList.size())
                .missionPreViewDTOList(memberMissionPreViewDTOList)
                .build();
    }
}
